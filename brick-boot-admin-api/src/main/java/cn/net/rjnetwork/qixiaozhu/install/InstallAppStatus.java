package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install app status model.
 */
@Data
public class InstallAppStatus {
    private Integer normalPort;
    private String webStaticRoot;
    private Boolean jwtSecretConfigured;
    private Boolean requestCryptoPrivateKeyConfigured;
    private Boolean requestCryptoPublicKeyConfigured;
}
