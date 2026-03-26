package cn.net.rjnetwork.qixiaozhu.monitor;

import lombok.Data;

/**
 * Public runtime system info model.
 */
@Data
public class SystemInfo {
    private String javaVersion;
    private String javaVendor;
    private long availableMemory;
    private long totalMemory;
    private long maxMemory;
    private String osName;
    private String osVersion;
    private String osArch;
    private int processors;
    private String appName;
    private long timestamp;
}
