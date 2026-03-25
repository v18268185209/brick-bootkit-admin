package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

import java.util.List;

@Data
public class BatchSavePermissionRequest {
    private Long userId;
    private List<PermissionItem> permissions;

    @Data
    public static class PermissionItem {
        private String permCode;
        private String companyIds;
    }
}
