package cn.net.rjnetwork.qixiaozhu.machine;

import lombok.Data;

/**
 * Public hardware info model used by machine code API.
 */
@Data
public class MachineHardwareInfo {
    private String macAddress;
    private String cpuInfo;
    private String boardInfo;
    private String diskSerial;
    private String systemInfo;
    private String runtimeInfo;
}
