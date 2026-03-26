package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

import java.util.List;

/**
 * Public install status model.
 */
@Data
public class InstallStatus {
    private boolean installRequired;
    private boolean installed;
    private boolean pendingRestart;
    private boolean stateFileExists;
    private boolean overrideFileExists;
    private String stateFile;
    private String overrideFile;
    private Boolean autoSwitchEnabled;
    private Long autoSwitchDelayMs;
    private Integer installPort;
    private Integer normalPort;
    private String redirectLoginPath;
    private String redirectLoginUrl;
    private String webStaticRoot;
    private Boolean initializeDatabase;
    private Boolean jwtSecretConfigured;
    private Boolean requestCryptoPrivateKeyConfigured;
    private Boolean requestCryptoPublicKeyConfigured;
    private Boolean sqlScriptAvailable;
    private String sqlScriptDirectory;
    private List<String> sqlScriptFiles;
    private List<String> missingSqlScripts;
    private InstallAppStatus app;
    private InstallMysqlStatus mysql;
    private InstallRedisStatus redis;
    private InstallAdminStatus admin;
}
