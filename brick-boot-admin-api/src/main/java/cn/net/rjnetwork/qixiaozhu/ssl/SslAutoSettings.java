package cn.net.rjnetwork.qixiaozhu.ssl;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Effective SSL automation settings after configuration merging.
 */
@Data
public class SslAutoSettings {
    private boolean enabled;
    private boolean autoIssueIfMissing;
    private boolean autoRenewEnabled;
    private boolean autoApplyEnabled;
    private boolean autoRestartEnabled;
    private long autoRestartDelayMs;
    private String acmeServerUrl;
    private String contactEmail;
    private List<String> domains = new ArrayList<>();
    private String dnsProvider;
    private String dnsRootDomain;
    private String dnsSecretId;
    private String dnsSecretKey;
    private String dnsRegion;
    private String certDir;
    private String keyAlias;
    private String keyStorePassword;
    private int renewBeforeDays;
    private int remindBeforeDays;
    private String checkCron;
    private int dnsPropagationWaitSeconds;
    private int acmePollIntervalSeconds;
    private int acmePollTimeoutSeconds;
}
