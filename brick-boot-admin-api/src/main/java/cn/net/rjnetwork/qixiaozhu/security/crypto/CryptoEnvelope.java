package cn.net.rjnetwork.qixiaozhu.security.crypto;

import lombok.Data;

/**
 * Public encrypted transport envelope contract.
 */
@Data
public class CryptoEnvelope {
    private String ek;
    private String iv;
    private String ct;
    private String tag;
}
