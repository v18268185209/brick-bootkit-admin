package cn.net.rjnetwork.qixiaozhu.monitor;

import lombok.Data;

/**
 * Public performance metrics snapshot model.
 */
@Data
public class PerformanceMetrics {
    private double qps;
    private double memoryUsageRate;
    private long heapMemoryUsed;
    private long heapMemoryMax;
    private double systemCpuLoad;
    private int availableProcessors;
    private int activeConnections;
    private int idleConnections;
    private int totalConnections;
    private long totalRequests;
    private double successRate;
    private double averageResponseTime;
}
