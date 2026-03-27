package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Request payload for install environment checks and preparation.
 */
@Data
public class InstallEnvironmentRequest {
    private boolean installMysql;
    private boolean installRedis;
}
