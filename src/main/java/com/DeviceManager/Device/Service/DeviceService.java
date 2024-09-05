package com.DeviceManager.Device.Service;

import com.DeviceManager.Device.Entity.Device;
import com.DeviceManager.Device.Exception.AppException;
import com.DeviceManager.Device.Exception.ErrorCode;
import com.DeviceManager.Device.Repository.DeviceRepository;
import com.DeviceManager.Device.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
    public Device GetDeviceById(int id) {
        return deviceRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.NOT_FOUND_DEVICE));
    }

    public Device CreateNewDevice(DeviceDTO request) {
        Device device = new Device();
        if(deviceRepository.existsByCode(request.getCode())){
            throw new AppException(ErrorCode.CODE_EXISTED);
        }
        device.setCode(request.getCode());
        device.setType(request.getType());
        device.setSerial(request.getSerial());
        device.setImei(request.getImei());
        device.setPurchaseDate(request.getPurchaseDate());
        device.setMac(request.getMac());
        device.setStatus(request.getStatus());
        device.setCurrentArea(request.getCurrentArea());
        return deviceRepository.save(device);
    }

    public Device UpdateInfoDevice(int id, DeviceDTO request) {
            Device device = GetDeviceById(id);
            if(deviceRepository.existsByCodeAndId(request.getCode(), id)){
                device.setCode(request.getCode());
                device.setType(request.getType());
                device.setSerial(request.getSerial());
                device.setImei(request.getImei());
                device.setPurchaseDate(request.getPurchaseDate());
                device.setMac(request.getMac());
                device.setStatus(request.getStatus());
                device.setCurrentArea(request.getCurrentArea());
                return deviceRepository.save(device);
            }
            if(deviceRepository.existsByCode(request.getCode())){
                throw new AppException(ErrorCode.CODE_EXISTED);
            }
            device.setCode(request.getCode());
            device.setType(request.getType());
            device.setSerial(request.getSerial());
            device.setImei(request.getImei());
            device.setPurchaseDate(request.getPurchaseDate());
            device.setMac(request.getMac());
            device.setStatus(request.getStatus());
            device.setCurrentArea(request.getCurrentArea());
            return deviceRepository.save(device);
    }



    public void DeleteDevice(int id) {
        deviceRepository.deleteById(id);
    }
}
