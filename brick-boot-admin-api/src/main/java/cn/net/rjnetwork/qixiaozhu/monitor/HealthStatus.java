package cn.net.rjnetwork.qixiaozhu.monitor;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Public health status model.
 */
@Data
public class HealthStatus {
    private String status;
    private Map<String, Object> details;

    public HealthStatus(String status) {
        this.status = status;
        this.details = new HashMap<>();
    }

    public HealthStatus withDetail(String key, Object value) {
        this.details.put(key, value);
        return this;
    }

    public static HealthStatus up() {
        return new HealthStatus("UP");
    }

    public static HealthStatus down() {
        return new HealthStatus("DOWN");
    }
}
