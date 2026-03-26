package cn.net.rjnetwork.qixiaozhu.install;

/**
 * Public lightweight install status view.
 */
public record InstallPublicStatus(boolean installRequired, boolean installed, boolean pendingRestart) {
}
