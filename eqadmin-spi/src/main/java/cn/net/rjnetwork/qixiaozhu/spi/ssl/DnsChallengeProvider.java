package cn.net.rjnetwork.qixiaozhu.spi.ssl;

import cn.net.rjnetwork.qixiaozhu.ssl.SslAutoSettings;

import java.util.Map;

/**
 * DNS provider contract for ACME DNS-01 challenge operations.
 */
public interface DnsChallengeProvider {

    String providerCode();

    boolean supports(String provider);

    String normalizeProvider(String provider);

    void validateProviderSettings(SslAutoSettings settings);

    String createTxtRecord(SslAutoSettings settings, String rrName, String value) throws Exception;

    void deleteTxtRecord(SslAutoSettings settings, String recordRef);

    Map<String, Object> testConnection(SslAutoSettings settings) throws Exception;
}
