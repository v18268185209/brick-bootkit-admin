package cn.net.rjnetwork.qixiaozhu.core.constpara;

/**
 * Public base constants shared by host and plugins.
 */
public class BaseConst {

    public static final String HEADER_APPID = "headerAppId";
    public static final String HEADER_APPSERECT = "headerAppserect";
    public static final String HEADER_TOKEN = "headerToken";
    public static final String HEADER_TIME = "headerTime";
    public static final String API_STR = "api";
    public static final String DIR_STR = "dir";
    public static final String MENU_STR = "menu";
    public static final String APP_STR = "app";
    public static final String BUTTON_STR = "button";
    public static final String COMPOMENTS_STR = "compoments";

    public static final String STATUE_OK = "ok";
    public static final String STATUE_FAILED = "failed";

    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NINE = 9;
    public static final Integer TEN = 10;

    public static final String ZERO_STR = "0";
    public static final String ONE_STR = "1";
    public static final String TWO_STR = "2";
    public static final String THREE_STR = "3";
    public static final String FOUR_STR = "4";
    public static final String FIVE_STR = "5";
    public static final String SIX_STR = "6";
    public static final String SEVEN_STR = "7";
    public static final String EIGHT_STR = "8";
    public static final String NINE_STR = "9";
    public static final String TEN_STR = "10";
    public static final String BOOLEARN_TRUE_STR = "true";
    public static final String BOOLEARN_FALSE_STR = "false";

    public static final String IP_APP_ENABLED = "IP_APP_ENABLED";
    public static final String IP_BLACK_LIST = "IP_BLACK_LIST";
    public static final String IP_WHITE_LIST = "IP_WHITE_LIST";
    public static final String IP_RULES_JSON = "IP_RULES_JSON";
    public static final String IP_DEFAULT_BLOCK_TIME = "IP_DEFAULT_BLOCK_TIME";
    public static final String IP_AUTO_CLEAN_EXPIRED = "IP_AUTO_CLEAN_EXPIRED";
    public static final String IP_LOG_BLOCK_EVENTS = "IP_LOG_BLOCK_EVENTS";

    public static final String TYPE = "type";
    public static final long TIMEOUT = 60 * 1000L;
    public static final long DOWN_TIMEOUT = 60 * 1000L * 60L * 24L;
    public static final String SUPER = "super";
    public static final String SUPER_LEGACY = "supper";

    public static final String LOCAL_BASEURL = "local_baseurl";
    public static final String LOCAL_DOMAIN = "local_domain";
    public static final String LOCAL_PLATFORM = "qixiaozhu-local-one";
    public static final String corsHeaders = "corsHeaders";
    public static final String corsMethods = "corsMethods";
    public static final Boolean corsCredentials = false;
    public static final Integer corsMaxAge = 3600;
    public static final String corsOrigin = "OriginHeader";

    public static final String aliyunAccessKey = "aliyunAccessKey";
    public static final String aliyunAccessKeySecret = "aliyunAccessKeySecret";
    public static final String aliyunOssBaseurl = "aliyunOssBaseurl";
    public static final String aliyunBucket = "aliyunBucket";
    public static final String aliyunEndpoint = "aliyunEndpoint";
    public static final String aliyunOssDomain = "aliyunOssDomain";

    public static final String tencentCosKey = "tencentCosKey";
    public static final String tencentAccessKey = "tencentAccessKey";
    public static final String tencentAccessId = "tencentSecretId";
    public static final String tencentOssBaseurl = "tencentOssBaseurl";
    public static final String tencentBucket = "tencentBucket";
    public static final String tencentEndpoint = "tencentRegion";
    public static final String tencentOssDomain = "tencentOssDomain";
    public static final String tencentOssPlatform = "tencentOssPlatform";

    public static final String trademarkerPlatForm = "aliyunBucketTrademarkerPlatForm";
    public static final String defaultFileStorge = "local-storage";
    public static final String TENCENT_SMS_CONFIG = "TENCENT_SMS_CONFIG";
    public static final String TENCENT_GROUP = "TENCENT_GROUP";
    public static final String ALIYUN_SMS_CONFIG = "ALIYUN_SMS_CONFIG";
    public static final String ALIYUN_GROUP = "ALIYUN_GROUP";
    public static final String BAIDU_SMS_CONFIG = "BAIDU_SMS_CONFIG";
    public static final String BAIDU_GROUP = "BAIDU_GROUP";
    public static final String QINIU_SMS_CONFIG = "QINIU_SMS_CONFIG";
    public static final String QINIU_GROUP = "QINIU_GROUP";
    public static final String JD_SMS_CONFIG = "JD_SMS_CONFIG";
    public static final String JD_GROUP = "JD_GROUP";
    public static final String YD_SMS_CONFIG = "YD_SMS_CONFIG";
    public static final String YD_GROUP = "YD_GROUP";
    public static final String SYSTEM_IPV4 = "SYSTEM_IPV4";
    public static final String SQL_SCRIPT_SEPT = "------------------------------------------------------------------------------------";
    public static final String SQL_TABLE_SEPT = "@@@@";
    public static final String PUBLIC_ROOT_PATH = System.getProperty("user.dir");
    public static final String SMS_PROPS = "classpath:sms.properties";
    public static final String SYSTEM_CONFIG = "system-config";
    public static final String DATA_PERMS_ENABLED = "dataPermEnabled";
    public static final String DATA_PERMS_USER_IDS = "dataPermissionUserId";

    public static final String EMAIL_LOGIN_VERIFY_CODE_CACHE_KEY = "email_login_verify_code_cache_key";
    public static final String PHONE_LOGIN_VERIFY_CODE_CACHE_KEY = "phone_login_verify_code_cache_key";

    public static final String PNG = "png";
    public static final String WXHELPER_TOPIC = "WXHELPER_TOPIC_666888";
    public static final String SQL_SUFFIX = ".sql";
    public static final String WEBSOCKET_MESSAGE_TOPIC = "webSocketMessageTopic";
    public static final String UPLOAD_FILE_BASE_PATH = "/upload/files/**";

    public static boolean isSuperAccountType(String accountType) {
        if (accountType == null) {
            return false;
        }
        String normalized = accountType.trim();
        return SUPER.equalsIgnoreCase(normalized) || SUPER_LEGACY.equalsIgnoreCase(normalized);
    }
}
