package cn.net.rjnetwork.qixiaozhu.spi.storage;

import cn.net.rjnetwork.qixiaozhu.storage.StoragePlatformType;
import cn.net.rjnetwork.qixiaozhu.storage.model.StorageConnectionResult;
import cn.net.rjnetwork.qixiaozhu.storage.model.StoragePlatformConfigSpec;

import java.util.List;

/**
 * Public storage platform extension contract.
 */
public interface StoragePlatformProvider {

    StoragePlatformType getPlatformType();

    default boolean supports(String platformType) {
        return getPlatformType().getCode().equalsIgnoreCase(platformType);
    }

    StorageConnectionResult testConnection(StoragePlatformConfigSpec config);

    List<ConfigItem> getConfigItems();

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
