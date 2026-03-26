package cn.net.rjnetwork.qixiaozhu.vo;

import lombok.Data;

/**
 * Public command execution result model.
 */
@Data
public class CommandExecutionResult {
    private String command;
    private Integer exitCode;
    private boolean success;
    private boolean timedOut;
    private String output;
}
