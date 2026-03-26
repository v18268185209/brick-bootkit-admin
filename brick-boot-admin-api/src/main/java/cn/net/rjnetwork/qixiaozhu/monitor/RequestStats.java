package cn.net.rjnetwork.qixiaozhu.monitor;

import lombok.Data;

/**
 * Public request statistics model.
 */
@Data
public class RequestStats {
    private long totalRequests;
    private long successRequests;
    private long failedRequests;
    private double successRate;
    private double failureRate;
    private double averageResponseTime;
}
