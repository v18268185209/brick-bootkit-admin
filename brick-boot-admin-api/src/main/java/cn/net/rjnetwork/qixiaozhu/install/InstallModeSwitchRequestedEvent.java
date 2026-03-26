package cn.net.rjnetwork.qixiaozhu.install;

/**
 * Public lifecycle event published when install flow is completed and mode switch can be triggered.
 */
public final class InstallModeSwitchRequestedEvent {

    private final long timestamp;

    public InstallModeSwitchRequestedEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
