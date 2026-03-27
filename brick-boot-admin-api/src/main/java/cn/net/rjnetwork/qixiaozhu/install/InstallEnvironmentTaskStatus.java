package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Public async task status model for install environment preparation.
 */
@Data
public class InstallEnvironmentTaskStatus {
    private String taskId;
    private String status;
    private Boolean success;
    private String message;
    private boolean installMysql;
    private boolean installRedis;
    private InstallEnvironmentServiceStatus docker;
    private InstallEnvironmentServiceStatus mysql;
    private InstallEnvironmentServiceStatus redis;
    private List<String> logs = new ArrayList<>();
    private long startedAt;
    private Long finishedAt;
    private long updatedAt;
}
