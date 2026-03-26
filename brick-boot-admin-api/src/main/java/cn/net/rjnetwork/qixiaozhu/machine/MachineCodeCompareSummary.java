package cn.net.rjnetwork.qixiaozhu.machine;

import lombok.Data;

/**
 * Public machine code compare summary model.
 */
@Data
public class MachineCodeCompareSummary {
    private String currentMachineCode;
    private String currentMachineCodeRaw;
    private Long generateTime;
    private MachineHardwareAvailability hardwareSummary;
}
