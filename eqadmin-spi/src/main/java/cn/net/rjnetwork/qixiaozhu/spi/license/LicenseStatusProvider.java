package cn.net.rjnetwork.qixiaozhu.spi.license;

import cn.net.rjnetwork.qixiaozhu.service.LicenseMode;

import java.util.Map;

/**
 * Provides runtime license status and snapshots.
 */
public interface LicenseStatusProvider {

    LicenseMode currentMode();

    Map<String, Object> queryStatus(boolean refresh);

    Map<String, Object> queryFeatureSnapshot(boolean refresh);

    Map<String, Object> queryMetricsSnapshot(boolean logNow);
}
