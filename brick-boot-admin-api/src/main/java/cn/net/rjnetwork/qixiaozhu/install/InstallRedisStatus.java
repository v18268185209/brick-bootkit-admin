package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install redis status model.
 */
@Data
public class InstallRedisStatus {
    private boolean configured;
    private String host;
    private Integer port;
    private Integer database;
    private Integer timeoutMs;
}
