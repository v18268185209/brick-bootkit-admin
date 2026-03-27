package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public environment precheck result model for install mode.
 */
@Data
public class InstallEnvironmentCheckResult {
    private boolean agreementAccepted;
    private boolean installMysql;
    private boolean installRedis;
    private boolean allPassed;
    private InstallEnvironmentServiceStatus docker;
    private InstallEnvironmentServiceStatus mysql;
    private InstallEnvironmentServiceStatus redis;
    private long checkedAt;
}
