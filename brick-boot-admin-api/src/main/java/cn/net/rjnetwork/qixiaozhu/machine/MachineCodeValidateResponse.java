package cn.net.rjnetwork.qixiaozhu.machine;

import lombok.Data;

/**
 * Public machine code validation result model.
 */
@Data
public class MachineCodeValidateResponse {
    private Boolean valid;
    private String message;
    private String currentMachineCode;

    public static MachineCodeValidateResponse success(String message) {
        MachineCodeValidateResponse response = new MachineCodeValidateResponse();
        response.setValid(true);
        response.setMessage(message);
        return response;
    }

    public static MachineCodeValidateResponse fail(String message, String currentCode) {
        MachineCodeValidateResponse response = new MachineCodeValidateResponse();
        response.setValid(false);
        response.setMessage(message);
        response.setCurrentMachineCode(currentCode);
        return response;
    }
}
