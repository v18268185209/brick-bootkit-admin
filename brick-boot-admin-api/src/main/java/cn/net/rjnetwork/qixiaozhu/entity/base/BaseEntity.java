package cn.net.rjnetwork.qixiaozhu.entity.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Public persistence base entity for plugin-side domain models.
 */
@Data
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新人id")
    private Long updateUserId;

    @Schema(description = "单位id")
    private Long companyId;

    @Schema(description = "部门id")
    private Long deptId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "是否删除 0 未删除 1 已删除")
    private Integer isDeleted;

    @Schema(description = "状态 0 禁用 1 启用 ")
    private Integer status;
}
