package com.DeviceManager.Device.Controller;

import com.DeviceManager.Device.Entity.Device;
import com.DeviceManager.Device.Service.DeviceService;
import com.DeviceManager.Device.dto.ApiResponse;
import com.DeviceManager.Device.dto.DeviceDTO;
import com.DeviceManager.Device.dto.smallDTO.GetCountDeviceDTO;
import com.DeviceManager.Device.dto.smallDTO.GetDeviceDTO;
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

    @GetMapping("/devices/only-codes")
    public List<GetDeviceDTO> getDeviceDTOList(){
        return deviceService.GetAllOnlyCode();
    }

    @GetMapping("/devices/tableSplit/{offsetValueNumber}") //Lấy list sau khi offset
    public List<Device> getDeviceOffsetValue(@PathVariable int offsetValueNumber){
        return deviceService.splitTableDevice(offsetValueNumber);
    }
    @GetMapping("/devices/tableSplit")
    public int splitValuePage(){
        return deviceService.splitValuePage(); // Xem có bao nhiêu trang
    }

    @GetMapping("/devices/counts")
    public List<GetCountDeviceDTO> getCountDeviceDTOList(){
        return deviceService.getCountDeviceDTOList();
    }
}
