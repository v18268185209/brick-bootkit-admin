package cn.net.rjnetwork.qixiaozhu.spi.appmarket;

import java.util.Map;

/**
 * Client contract for plugin market browsing, ordering and download workflows.
 */
public interface PluginMarketClient {

    Map<String, Object> runtimeInfo();

    Map<String, Object> listPlugins(String keyword, String category, Integer page, Integer pageSize);

    Map<String, Object> pluginDetail(String pluginCode);

    Map<String, Object> createOrder(
            String pluginCode,
            String version,
            String machineCode,
            String customerName,
            String phone,
            String email,
            String payChannel
    );

    Map<String, Object> orderStatus(String orderNo);

    Map<String, Object> orderRequery(String orderNo);

    Map<String, Object> createDownloadTicket(String pluginCode, String version, String machineCode);
}
