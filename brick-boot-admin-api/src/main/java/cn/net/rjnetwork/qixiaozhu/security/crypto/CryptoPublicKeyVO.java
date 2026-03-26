package cn.net.rjnetwork.qixiaozhu.security.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Public request crypto public key metadata model.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoPublicKeyVO {
    private String kid;
    private String algorithm;
    private String publicKeyPem;
}
