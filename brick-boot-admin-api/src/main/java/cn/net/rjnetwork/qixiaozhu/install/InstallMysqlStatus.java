package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install mysql status model.
 */
@Data
public class InstallMysqlStatus {
    private boolean configured;
    private String driverClassName;
    private String url;
    private String username;
    private String databaseName;
}
