package cn.net.rjnetwork.qixiaozhu.message.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Public send result DTO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String messageId;
    private String errorMsg;
    private String errorCode;
    private Object responseData;

    public static SendResult success(String messageId) {
        return SendResult.builder()
                .success(true)
                .messageId(messageId)
                .build();
    }

    public static SendResult success(String messageId, Object responseData) {
        return SendResult.builder()
                .success(true)
                .messageId(messageId)
                .responseData(responseData)
                .build();
    }

    public static SendResult failed(String errorMsg) {
        return SendResult.builder()
                .success(false)
                .errorMsg(errorMsg)
                .build();
    }

    public static SendResult failed(String errorCode, String errorMsg) {
        return SendResult.builder()
                .success(false)
                .errorCode(errorCode)
                .errorMsg(errorMsg)
                .build();
    }
}
