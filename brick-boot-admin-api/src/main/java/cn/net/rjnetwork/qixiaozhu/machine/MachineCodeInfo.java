package cn.net.rjnetwork.qixiaozhu.machine;

import lombok.Data;

import java.util.Map;

/**
 * Public machine code detail model.
 */
@Data
public class MachineCodeInfo {
    private String machineCode;
    private String machineCodeRaw;
    private Boolean isValid;
    private Map<String, String> hardwareInfo;
    private Long generateTime;
}
