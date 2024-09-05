package com.DeviceManager.Device.Controller;

import com.DeviceManager.Device.Entity.Area;
import com.DeviceManager.Device.Service.AreaService;
import com.DeviceManager.Device.dto.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("areas")
    public List<Area> getAreas(){
        return areaService.getAllListAreas();
    }

    @GetMapping("areas/{AreaId}")
    public Area getArea(@PathVariable int AreaId){
        return areaService.getAreaById(AreaId);
    }

    @PutMapping("areas/{AreaId}")
    public Area updateArea(@PathVariable int AreaId, @RequestBody AreaDTO request){
        return areaService.updateArea(AreaId, request);
    }

    @GetMapping("areas/onlyArea")
    public List<Area> getAreasOnlyArea(){
        return areaService.getAllListOnlyAreas();
    }
}
