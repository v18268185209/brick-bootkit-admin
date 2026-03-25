package cn.net.rjnetwork.qixiaozhu.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * System monitor dashboard model.
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "SystemMonitorVO", description = "System health monitor aggregate model")
public class SystemMonitorVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime monitorTime;
    private Double cpuUsageRate;
    private String cpuStatus;
    private Double memoryUsageRate;
    private String memoryStatus;
    private Double systemLoad;
    private String loadStatus;
    private PerformanceTrendVO performanceTrend;
    private Double diskUsageRate;
    private String diskStatus;
    private List<DiskPartitionVO> diskPartitions;
    private TaskExecutionStatsVO taskExecutionStats;
    private List<ScheduledTaskVO> scheduledTasks;
    private NetworkStatsVO networkStats;
    private String operatingSystem;
    private String uptime;
    private Integer cpuCores;
    private Long totalMemory;

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class PerformanceTrendVO implements Serializable {
        private static final long serialVersionUID = 1L;
        private List<String> timePoints;
        private List<Double> cpuUsageList;
        private List<Double> memoryUsageList;
    }

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class DiskPartitionVO implements Serializable {
        private static final long serialVersionUID = 1L;
        private String partitionName;
        private String driveLetter;
        private Long usedSpace;
        private Long totalSpace;
        private Double usageRate;
        private String status;
    }

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class TaskExecutionStatsVO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Integer runningTasks;
        private Integer queuedTasks;
        private Integer parallelTasks;
        private Long completedTasks;
        private Integer failedTasks;
        private Double successRate;
        private String status;
    }

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class ScheduledTaskVO implements Serializable {
        private static final long serialVersionUID = 1L;
        private String taskId;
        private String taskName;
        private String cronExpression;
        private LocalDateTime nextExecutionTime;
        private LocalDateTime lastExecutionTime;
        private String status;
        private String executionDuration;
        private Double successRate;
        private String lastExecutionStatus;
    }

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class NetworkStatsVO implements Serializable {
        private static final long serialVersionUID = 1L;
        private Double inboundTraffic;
        private Double outboundTraffic;
        private Integer connections;
    }
}
