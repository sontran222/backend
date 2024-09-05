package com.DeviceManager.Device.Controller;

import com.DeviceManager.Device.Entity.History;
import com.DeviceManager.Device.Service.HistoryService;
import com.DeviceManager.Device.dto.ApiResponse;
import com.DeviceManager.Device.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping("/histories")
    ApiResponse<History> addHistory(@RequestBody HistoryDTO request) {
        ApiResponse<History> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(historyService.createHistory(request));
        return apiResponse;
    }

    @GetMapping("/histories")
    ApiResponse<List<History>> getHistory() {
        ApiResponse<List<History>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(historyService.getAllHistory());
        return apiResponse;
    }

    @GetMapping("/histories/{id}")
    ApiResponse<History> getHistoryById(@PathVariable int id) {
        ApiResponse<History> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(historyService.getHistoryById(id));
        return apiResponse;
    }

    @DeleteMapping("/histories/{id}")
    ApiResponse<History> deleteHistoryById(@PathVariable int id) {
        ApiResponse<History> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("Delete Successful");
        historyService.deleteHistoryById(id);
        return apiResponse;
    }
}
