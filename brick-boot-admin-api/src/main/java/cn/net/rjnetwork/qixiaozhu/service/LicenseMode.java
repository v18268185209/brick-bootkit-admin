package cn.net.rjnetwork.qixiaozhu.service;

import java.util.Locale;

/**
 * Public license mode enum kept in the original package for compatibility.
 */
public enum LicenseMode {
    ONLINE,
    OFFLINE;

    public String value() {
        return name().toLowerCase(Locale.ROOT);
    }
}
