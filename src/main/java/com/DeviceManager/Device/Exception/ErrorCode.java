package com.DeviceManager.Device.Exception;

public enum ErrorCode {
    CODE_EXISTED(5001, "Code đã tồn tại"),
    CODE_INVALID(5000, "Tối thiểu code có 1 kí tự"),
    NOT_FOUND_DEVICE(6000, "Không tìm thấy thiết bị"),
    NOT_FOUND_HISTORY(7000, "Không tìm thấy lịch sử")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
