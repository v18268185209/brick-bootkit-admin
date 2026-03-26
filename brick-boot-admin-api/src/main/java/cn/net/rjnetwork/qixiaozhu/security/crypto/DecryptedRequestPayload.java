package cn.net.rjnetwork.qixiaozhu.security.crypto;

import lombok.Data;

import java.util.Map;

/**
 * Public decrypted request payload contract.
 */
@Data
public class DecryptedRequestPayload {
    private String ct;
    private Map<String, Object> params;
    private Object body;
}
