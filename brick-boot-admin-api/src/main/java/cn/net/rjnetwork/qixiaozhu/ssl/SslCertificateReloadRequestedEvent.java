package cn.net.rjnetwork.qixiaozhu.ssl;

/**
 * Public lifecycle event for restarting app after certificate is updated and applied.
 */
public final class SslCertificateReloadRequestedEvent {

    private final long timestamp;
    private final String reason;

    public SslCertificateReloadRequestedEvent(String reason) {
        this.timestamp = System.currentTimeMillis();
        this.reason = reason == null ? "ssl-cert-updated" : reason;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getReason() {
        return reason;
    }
}
