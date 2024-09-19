package com.DeviceManager.Device.Service;

import com.DeviceManager.Device.Entity.Device;
import com.DeviceManager.Device.Exception.AppException;
import com.DeviceManager.Device.Exception.ErrorCode;
import com.DeviceManager.Device.Repository.DeviceRepository;
import com.DeviceManager.Device.dto.DeviceDTO;
import com.DeviceManager.Device.dto.smallDTO.GetCountDeviceDTO;
import com.DeviceManager.Device.dto.smallDTO.GetDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<GetDeviceDTO> GetAllOnlyCode(){
        List<String> getCodes = deviceRepository.findAllOnlyCode();
        List<GetDeviceDTO> getDeviceDTOS = new ArrayList<>();
        for(String i : getCodes){
            String code = i;
            GetDeviceDTO getDeviceDTO = new GetDeviceDTO(code);
            getDeviceDTOS.add(getDeviceDTO);
        }
        return getDeviceDTOS;
    }

    public List<Device> splitTableDevice(int offsetValue){
        int offset = (offsetValue - 1) * 8;
        List<Device> devices = deviceRepository.splitTableDevice(offset);
        return devices;
    }

    public int splitValuePage(){
        int tableSplitPage = (int) Math.ceil((double)deviceRepository.countTableDevice() / 8);
        return tableSplitPage;
    }

    public List<GetCountDeviceDTO> getCountDeviceDTOList(){
        List<Object[]> getObjects = deviceRepository.getCountTableDevice();
        List<GetCountDeviceDTO> ListCount = new ArrayList<>();
        for(Object[] obj: getObjects){
            GetCountDeviceDTO getCountDeviceDTO = new GetCountDeviceDTO(
                    (String) obj[0],
                    ((BigDecimal) obj[1]).intValue(),
                    ((BigDecimal) obj[2]).intValue()
            );
            ListCount.add(getCountDeviceDTO);

        }
        return ListCount;
    }
}
