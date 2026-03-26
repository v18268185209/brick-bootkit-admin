package cn.net.rjnetwork.qixiaozhu.install;

import lombok.Data;

/**
 * Public install admin status model.
 */
@Data
public class InstallAdminStatus {
    private String account;
    private String email;
    private String phone;
    private Boolean passwordConfigured;
}
