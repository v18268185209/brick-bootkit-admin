package cn.net.rjnetwork.qixiaozhu.message.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Public message event type contract.
 */
@Getter
@RequiredArgsConstructor
public enum MessageEventType {

    TASK_START("TASK_START", "任务开始执行", "任务开始执行时触发"),
    TASK_SUCCESS("TASK_SUCCESS", "任务执行成功", "任务执行成功时触发"),
    TASK_FAILED("TASK_FAILED", "任务执行失败", "任务执行失败时触发"),
    TASK_TIMEOUT("TASK_TIMEOUT", "任务执行超时", "任务执行超时时触发"),
    TASK_EXPIRING("TASK_EXPIRING", "任务即将过期", "任务即将过期时触发"),

    SYSTEM_ALERT("SYSTEM_ALERT", "系统告警", "系统发生告警时触发"),
    SYSTEM_NOTICE("SYSTEM_NOTICE", "系统通知", "系统发布通知时触发"),
    SYSTEM_EXCEPTION("SYSTEM_EXCEPTION", "系统异常", "系统发生异常时触发"),

    API_TRIGGER("API_TRIGGER", "API接口触发", "通过 API 接口主动触发"),
    MANUAL_TRIGGER("MANUAL_TRIGGER", "手动触发", "用户手动操作触发"),

    USER_REGISTER("USER_REGISTER", "用户注册", "新用户注册时触发"),
    USER_LOGIN("USER_LOGIN", "用户登录", "用户登录时触发"),
    APPROVAL_NOTICE("APPROVAL_NOTICE", "审批通知", "待审批事项通知");

    private final String code;
    private final String name;
    private final String description;

    public static MessageEventType getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (MessageEventType type : values()) {
            if (type.getCode().equalsIgnoreCase(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isValid(String code) {
        return getByCode(code) != null;
    }
}
