package cn.net.rjnetwork.qixiaozhu.storage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Public storage platform configuration payload.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoragePlatformConfigSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    private String platformName;
    private String platformType;
    private String platformDesc;
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String endpoint;
    private String domain;
    private String basePath;
    private String region;
    private Boolean defaultPlatform;
    private Boolean enabled;
}
