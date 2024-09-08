package com.DeviceManager.Device.dto.smallDTO;

public class GetDeviceDTO {
    private String code;

    public GetDeviceDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
