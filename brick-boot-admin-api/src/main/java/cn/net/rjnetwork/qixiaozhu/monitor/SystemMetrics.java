package cn.net.rjnetwork.qixiaozhu.monitor;

import lombok.Data;

/**
 * Public system metrics model.
 */
@Data
public class SystemMetrics {
    private long heapMemoryUsed;
    private long heapMemoryMax;
    private long nonHeapMemoryUsed;
    private long nonHeapMemoryMax;
    private long totalMemoryUsed;
    private long totalMemoryMax;
    private long systemTotalMemory;
    private long systemFreeMemory;
    private long systemUsedMemory;
    private double systemCpuLoad;
    private int availableProcessors;
    private long uptime;
    private int activeConnections;
    private int idleConnections;
    private int totalConnections;
}
