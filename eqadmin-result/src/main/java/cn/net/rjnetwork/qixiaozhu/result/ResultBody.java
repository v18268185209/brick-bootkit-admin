package cn.net.rjnetwork.qixiaozhu.result;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.net.rjnetwork.qixiaozhu.core.constpara.CodeConst;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Unified response body model used across public APIs.
 *
 * @param <T> payload type
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBody<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonView(View.Public.class)
    private String code;

    @JsonView(View.Public.class)
    private String message;

    @JsonView(View.Public.class)
    private T result;

    @JsonView(View.Public.class)
    private LocalDateTime timestamp;

    @JsonView(View.Detail.class)
    private PageInfo pageInfo;

    @JsonView(View.Internal.class)
    private String traceId;

    public ResultBody(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.result = sanitizeForJson(data);
        this.timestamp = LocalDateTime.now();
    }

    @SuppressWarnings("unchecked")
    public void setResult(T result) {
        this.result = sanitizeForJson(result);
    }

    public static <T> ResultBody<T> success() {
        return new ResultBody<>(CodeConst.SUCCESS_CODE, CodeConst.SUCCESS_MSG, null);
    }

    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<>(CodeConst.SUCCESS_CODE, CodeConst.SUCCESS_MSG, data);
    }

    public static <T> ResultBody<T> success(String message, T data) {
        return new ResultBody<>(CodeConst.SUCCESS_CODE, message, data);
    }

    public static <T> ResultBody<T> successMsg(String message) {
        return new ResultBody<>(CodeConst.SUCCESS_CODE, message, null);
    }

    public static <T> ResultBody<T> success(T data, long total, long pageNum, long pageSize) {
        ResultBody<T> result = new ResultBody<>(CodeConst.SUCCESS_CODE, CodeConst.SUCCESS_MSG, data);
        result.setPageInfo(new PageInfo(total, pageNum, pageSize));
        return result;
    }

    public static <T> ResultBody<T> error(String code, String message) {
        return new ResultBody<>(code, message, null);
    }

    public static <T> ResultBody<T> error(String message) {
        return new ResultBody<>(CodeConst.FAILED_CODE, message, null);
    }

    public static <T> ResultBody<T> error(Throwable throwable) {
        return new ResultBody<>(CodeConst.FAILED_CODE, throwable.getMessage(), null);
    }

    public static <T> ResultBody<T> error(String code, String message, T data) {
        return new ResultBody<>(code, message, data);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public boolean isSuccess() {
        return CodeConst.SUCCESS_CODE.equals(this.code);
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public T getDataOrElse(T defaultValue) {
        return this.result != null ? this.result : defaultValue;
    }

    public ResultBody<T> withTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonPrettyStr(this);
    }

    public static class Builder<T> {
        private String code;
        private String message;
        private T data;
        private String traceId;

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> traceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public ResultBody<T> build() {
            ResultBody<T> result = new ResultBody<>(code, message, data);
            result.setTimestamp(LocalDateTime.now());
            if (traceId != null) {
                result.setTraceId(traceId);
            }
            return result;
        }

        public ResultBody<T> success() {
            return code(CodeConst.SUCCESS_CODE).message(CodeConst.SUCCESS_MSG).build();
        }

        public ResultBody<T> success(T data) {
            return code(CodeConst.SUCCESS_CODE).message(CodeConst.SUCCESS_MSG).data(data).build();
        }

        public ResultBody<T> error(String message) {
            return code(CodeConst.FAILED_CODE).message(message).build();
        }

        public ResultBody<T> error(String code, String message) {
            return code(code).message(message).build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class PageInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        private long total;
        private long pageNum;
        private long pageSize;
        private long pages;

        public PageInfo(long total, long pageNum, long pageSize) {
            this.total = total;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.pages = pageSize > 0 ? (long) Math.ceil((double) total / pageSize) : 0;
        }
    }

    public static class View {
        public interface Public {}
        public interface Detail extends Public {}
        public interface Internal extends Detail {}
    }

    @SuppressWarnings("unchecked")
    private static <T> T sanitizeForJson(T value) {
        return (T) sanitizeAny(value);
    }

    private static Object sanitizeAny(Object value) {
        if (value == null || value instanceof JSONNull) {
            return null;
        }
        if (value instanceof JSONObject jsonObject) {
            Map<String, Object> out = new LinkedHashMap<>();
            for (String key : jsonObject.keySet()) {
                out.put(key, sanitizeAny(jsonObject.get(key)));
            }
            return out;
        }
        if (value instanceof JSONArray jsonArray) {
            List<Object> out = new ArrayList<>(jsonArray.size());
            for (Object item : jsonArray) {
                out.add(sanitizeAny(item));
            }
            return out;
        }
        if (value instanceof Map<?, ?> map) {
            Map<Object, Object> out = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                out.put(entry.getKey(), sanitizeAny(entry.getValue()));
            }
            return out;
        }
        if (value instanceof Iterable<?> iterable) {
            List<Object> out = new ArrayList<>();
            for (Object item : iterable) {
                out.add(sanitizeAny(item));
            }
            return out;
        }
        Class<?> clazz = value.getClass();
        if (clazz.isArray()) {
            int len = Array.getLength(value);
            List<Object> out = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                out.add(sanitizeAny(Array.get(value, i)));
            }
            return out;
        }
        return value;
    }
}
