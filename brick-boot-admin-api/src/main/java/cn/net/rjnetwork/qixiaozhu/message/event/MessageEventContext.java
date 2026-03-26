package cn.net.rjnetwork.qixiaozhu.message.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Public message event context contract.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageEventContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private Long deptId;

    private Long companyId;

    private String source;

    private String sourceModule;

    private String sourceId;

    private Map<String, Object> extra;

    public static MessageEventContext create(Long userId, String source) {
        return MessageEventContext.builder()
                .userId(userId)
                .source(source)
                .build();
    }

    public static MessageEventContext createFull(Long userId,
                                                 String userName,
                                                 Long deptId,
                                                 Long companyId,
                                                 String source) {
        return MessageEventContext.builder()
                .userId(userId)
                .userName(userName)
                .deptId(deptId)
                .companyId(companyId)
                .source(source)
                .build();
    }
}
