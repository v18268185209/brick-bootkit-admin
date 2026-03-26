package cn.net.rjnetwork.qixiaozhu.account;

import lombok.Data;

import java.io.Serializable;

/**
 * Public current-account snapshot used by plugins.
 */
@Data
public class CurrentAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String account;
    private String realName;
    private String accountType;
    private Long companyId;
    private Long deptId;
}
