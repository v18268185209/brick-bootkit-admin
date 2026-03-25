package cn.net.rjnetwork.qixiaozhu.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Welcome page statistics model.
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "WelcomeStatsVO", description = "Core welcome dashboard statistics")
public class WelcomeStatsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime statsTime;
    private Long totalUsers;
    private Long totalRoles;
    private Long totalPermissions;
    private Long totalMenus;
    private Long totalDepts;
    private Long totalCompanies;
    private Long totalDicts;
    private Long totalRequestLogs;
    private Long todayNewUsers;
    private Long todayActiveUsers;
    private Long weekActiveUsers;
    private Long monthActiveUsers;
    private Map<String, Long> userStatusDistribution;
    private Long normalRoles;
    private Long lockedRoles;
    private Map<String, Long> roleTypeDistribution;
    private Long dirMenus;
    private Long menuMenus;
    private Long apiMenus;
    private Long buttonMenus;
    private Map<String, Long> menuTypeDistribution;
    private Long normalPermissions;
    private Long lockedPermissions;
    private Map<String, Long> permissionTypeDistribution;
    private Long onlineUsers;
    private Long todayRequests;
    private Double avgResponseTime;
    private Double requestSuccessRate;
    private Long todayErrorRequests;
    private Long totalDataPermConfigs;
    private Long totalUserRoleRelations;
    private Long totalMenuPermRelations;
    private Long totalDeptUserRelations;
}
