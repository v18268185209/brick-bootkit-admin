package cn.net.rjnetwork.qixiaozhu.machine;

import lombok.Data;

/**
 * Public machine hardware availability summary model.
 */
@Data
public class MachineHardwareAvailability {
    private String macAvailable;
    private String cpuAvailable;
    private String boardAvailable;
    private String diskAvailable;
}
