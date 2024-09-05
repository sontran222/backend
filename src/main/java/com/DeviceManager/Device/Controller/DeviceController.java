package com.DeviceManager.Device.Controller;

import com.DeviceManager.Device.Entity.Device;
import com.DeviceManager.Device.Service.DeviceService;
import com.DeviceManager.Device.dto.ApiResponse;
import com.DeviceManager.Device.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/devices/{deviceId}")
    public Device getDeviceById(@PathVariable int deviceId) {
        return deviceService.GetDeviceById(deviceId);
    }
    @PostMapping("/devices")
    ApiResponse<Device> addDevice(@RequestBody @Valid DeviceDTO request) {
        ApiResponse<Device> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(deviceService.CreateNewDevice(request));
        return apiResponse;
    }

    @PutMapping("/devices/{deviceId}")
    public Device UpdateInfoDevice(@PathVariable int deviceId ,@RequestBody DeviceDTO request) {
        return deviceService.UpdateInfoDevice(deviceId, request);
    }

    @DeleteMapping("/devices/{deviceId}")
    public String DeleteInfoDevice(@PathVariable int deviceId) {
        deviceService.DeleteDevice(deviceId);
        return "Đã xóa thành công";
    }

}
