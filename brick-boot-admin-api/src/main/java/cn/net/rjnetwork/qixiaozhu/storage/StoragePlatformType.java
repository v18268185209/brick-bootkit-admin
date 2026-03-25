package cn.net.rjnetwork.qixiaozhu.storage;

/**
 * Public storage platform enum definition.
 */
public enum StoragePlatformType {

    ALIYUN("aliyun", "Aliyun OSS"),
    TENCENT("tencent", "Tencent COS"),
    QINIU("qiniu", "Qiniu Kodo"),
    LOCAL("local", "Local Storage");

    private final String code;
    private final String displayName;

    StoragePlatformType(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static StoragePlatformType getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (StoragePlatformType type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isValid(String code) {
        return getByCode(code) != null;
    }
}
