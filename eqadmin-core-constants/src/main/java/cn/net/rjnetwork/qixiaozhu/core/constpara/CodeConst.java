package cn.net.rjnetwork.qixiaozhu.core.constpara;

/**
 * Unified response and error code constants.
 */
public final class CodeConst {

    private CodeConst() {
    }

    public static final String SUCCESS_CODE = "000000";
    public static final String SUCCESS_MSG = "Operation succeeded";

    public static final String FAILED_CODE = "000001";
    public static final String FAILED_MSG = "Operation failed";

    public static final String BAD_REQUEST_CODE = "400000";
    public static final String BAD_REQUEST_MSG = "Bad request";

    public static final String VALIDATION_FAILED_CODE = "400100";
    public static final String VALIDATION_FAILED_MSG = "Validation failed";

    public static final String UNAUTHORIZED_CODE = "401000";
    public static final String UNAUTHORIZED_MSG = "Unauthorized";

    public static final String FORBIDDEN_CODE = "403000";
    public static final String FORBIDDEN_MSG = "Forbidden";

    public static final String NOT_FOUND_CODE = "404000";
    public static final String NOT_FOUND_MSG = "Not found";

    public static final String METHOD_NOT_ALLOWED_CODE = "405000";
    public static final String METHOD_NOT_ALLOWED_MSG = "Method not allowed";

    public static final String INTERNAL_ERROR_CODE = "500000";
    public static final String INTERNAL_ERROR_MSG = "Internal server error";

    public static final String DATABASE_ERROR_CODE = "500100";
    public static final String DATABASE_ERROR_MSG = "Database error";

    public static final String BUSINESS_ERROR_CODE = "500200";
    public static final String BUSINESS_ERROR_MSG = "Business processing failed";

    public static final String FAILED_HEADER_ISNULL_CODE = "100000";
    public static final String FAILED_HEADER_ISNULL_MSG = "Missing request header";
    public static final String FAILED_NOT_PERMS_CODE = "200000";
    public static final String FAILED_NOT_PERMS_MSG = "Permission denied";
}
