package cn.net.rjnetwork.qixiaozhu.security.crypto;

import lombok.Data;

/**
 * Public encrypted response payload contract.
 */
@Data
public class EncryptedResponsePayload {
    private String v;
    private String kid;
    private long ts;
    private String nonce;
    private String iv;
    private String ct;
    private String tag;
    private String traceId;
}
