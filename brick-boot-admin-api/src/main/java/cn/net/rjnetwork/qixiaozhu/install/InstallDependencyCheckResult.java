package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

import java.util.List;

/**
 * Public dependency check result model.
 */
@Data
public class InstallDependencyCheckResult {
    private boolean allPassed;
    private boolean initializeDatabase;
    private boolean sqlScriptAvailable;
    private String sqlScriptDirectory;
    private List<String> sqlScriptFiles;
    private List<String> missingSqlScripts;
    private InstallDependencyCheckItem mysql;
    private InstallDependencyCheckItem redis;
    private long checkedAt;
}
