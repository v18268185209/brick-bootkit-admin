package cn.net.rjnetwork.qixiaozhu.storage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Public storage connection test result.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageConnectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String providerCode;
    private String platformName;
    private String message;

    public static StorageConnectionResult success(String providerCode, String platformName, String message) {
        return StorageConnectionResult.builder()
                .success(true)
                .providerCode(providerCode)
                .platformName(platformName)
                .message(message)
                .build();
    }

    public static StorageConnectionResult failed(String providerCode, String platformName, String message) {
        return StorageConnectionResult.builder()
                .success(false)
                .providerCode(providerCode)
                .platformName(platformName)
                .message(message)
                .build();
    }
}
