package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

import java.util.List;

/**
 * Public dependency check item model.
 */
@Data
public class InstallDependencyCheckItem {
    private boolean success;
    private String message;
    private String databaseName;
    private Boolean databaseExists;
    private Boolean databaseConnectionAvailable;
    private Boolean schemaReady;
    private Integer tableCount;
    private List<String> coreTables;
}
