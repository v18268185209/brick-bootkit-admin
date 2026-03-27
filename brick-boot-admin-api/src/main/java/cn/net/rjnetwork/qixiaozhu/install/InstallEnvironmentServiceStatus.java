package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install environment service status model.
 */
@Data
public class InstallEnvironmentServiceStatus {
    private boolean selected;
    private boolean success;
    private boolean available;
    private boolean installed;
    private boolean running;
    private boolean managed;
    private String message;
    private String version;
    private String host;
    private Integer port;
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
    private String databaseName;
    private Integer database;
    private Integer timeoutMs;
    private String envFile;
    private String dataDir;
    private String containerName;
    private String imageName;
}
