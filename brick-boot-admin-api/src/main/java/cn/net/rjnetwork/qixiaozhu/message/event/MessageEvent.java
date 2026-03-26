package cn.net.rjnetwork.qixiaozhu.message.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Public message event contract.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventId;

    private String eventType;

    private MessageEventContext context;

    private Map<String, Object> businessData;

    private Date createTime;

    public static MessageEvent create(String eventType, Map<String, Object> businessData) {
        return MessageEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .eventType(eventType)
                .businessData(businessData)
                .createTime(new Date())
                .build();
    }

    public static MessageEvent create(String eventType,
                                      MessageEventContext context,
                                      Map<String, Object> businessData) {
        return MessageEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .eventType(eventType)
                .context(context)
                .businessData(businessData)
                .createTime(new Date())
                .build();
    }
}
