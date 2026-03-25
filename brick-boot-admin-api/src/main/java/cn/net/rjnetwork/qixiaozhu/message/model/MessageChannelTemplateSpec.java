package cn.net.rjnetwork.qixiaozhu.message.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Public message channel template payload.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageChannelTemplateSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long messageTemplateId;
    private String channelType;
    private String channelTemplateCode;
    private String subject;
    private String content;
    private String paramsJson;
    private Integer priority;
    private Integer active;
}
