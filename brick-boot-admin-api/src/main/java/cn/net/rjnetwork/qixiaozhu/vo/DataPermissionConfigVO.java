package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.List;

/**
 * Data permission configuration view model.
 */
@Data
public class DataPermissionConfigVO {
    private Long userId;
    private String username;
    private String account;
    private String realName;
    private Long deptId;
    private String deptName;
    private Boolean enabled;
    private List<String> permTypes;
    private List<PermissionConfig> permissions;
}
