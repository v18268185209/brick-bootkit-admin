package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

/**
 * Install wizard payload for dependency and bootstrap configuration.
 */
@Data
public class InstallConfigPayload {

    private Boolean initializeDatabase = true;
    private MysqlConfig mysql = new MysqlConfig();
    private RedisConfig redis = new RedisConfig();
    private AppConfig app = new AppConfig();
    private AdminConfig admin = new AdminConfig();

    @Data
    public static class MysqlConfig {
        private String driverClassName = "com.mysql.cj.jdbc.Driver";
        private String url = "jdbc:mysql://127.0.0.1:3306/brick_bootkit_admin?useSSL=false&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
        private String username = "root";
        private String password = "";
    }

    @Data
    public static class RedisConfig {
        private String host = "127.0.0.1";
        private Integer port = 6379;
        private String password = "";
        private Integer database = 0;
        private Integer timeoutMs = 5000;
    }

    @Data
    public static class AppConfig {
        private Integer normalPort = 8002;
        private String jwtSecret = "";
        private String webStaticRoot = "";
        private String requestCryptoPrivateKeyPem = "";
        private String requestCryptoPublicKeyPem = "";
    }

    @Data
    public static class AdminConfig {
        private String account = "admin";
        private String password = "";
        private String email = "";
        private String phone = "";
    }
}
