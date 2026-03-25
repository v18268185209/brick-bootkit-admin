package cn.net.rjnetwork.qixiaozhu.spi.message;

import cn.net.rjnetwork.qixiaozhu.message.constant.MessageChannelType;
import cn.net.rjnetwork.qixiaozhu.message.event.ChannelConfigDTO;
import cn.net.rjnetwork.qixiaozhu.message.event.ReceiverDTO;
import cn.net.rjnetwork.qixiaozhu.message.event.SendResult;
import cn.net.rjnetwork.qixiaozhu.message.model.MessageChannelTemplateSpec;

import java.util.List;
import java.util.Map;

/**
 * Public message channel extension contract.
 */
public interface MessageChannel {

    MessageChannelType getChannelType();

    SendResult send(ChannelConfigDTO channelConfig,
                    List<ReceiverDTO> receivers,
                    MessageChannelTemplateSpec template,
                    Map<String, Object> params);

    boolean validateConfig(ChannelConfigDTO channelConfig);

    List<ConfigItem> getConfigItems();

    default boolean isAvailable() {
        return true;
    }

    record ConfigItem(
            String key,
            String name,
            String type,
            boolean required,
            String defaultValue,
            String description
    ) {
    }
}
