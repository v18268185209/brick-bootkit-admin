package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.List;

/**
 * Permission configuration detail model.
 */
@Data
public class PermissionConfig {
    private String permCode;
    private String permName;
    private String permType;
    private List<Long> deptIds;
    private List<String> deptNames;
    private List<Long> companyIds;
    private List<String> companyNames;
    private Boolean enabled;
}
