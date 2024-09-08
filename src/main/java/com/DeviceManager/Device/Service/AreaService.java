package com.DeviceManager.Device.Service;

import com.DeviceManager.Device.Entity.Area;
import com.DeviceManager.Device.Repository.AreaRepository;
import com.DeviceManager.Device.dto.AreaDTO;
import com.DeviceManager.Device.dto.smallDTO.GetAreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllListAreas(){
        return areaRepository.findAll();
    }

    public Area getAreaById(int id){
        return areaRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    public Area updateArea(int id,AreaDTO request){
        Area CurrentArea = getAreaById(id);
        CurrentArea.setPic(request.getPic());
        return areaRepository.save(CurrentArea);
    }


    public List<GetAreaDTO> getOnlyAreas(){
        List<String> results = areaRepository.findAllOnlyAreas();

        List<GetAreaDTO> getAreaDTOS = new ArrayList<>();

        for (String i : results) {
            String area = i;

            GetAreaDTO areaDTO = new GetAreaDTO(area);
            getAreaDTOS.add(areaDTO);
        }
        return getAreaDTOS;
    }
}
