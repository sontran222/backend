package com.DeviceManager.Device.Service;

import com.DeviceManager.Device.Entity.History;
import com.DeviceManager.Device.Exception.AppException;
import com.DeviceManager.Device.Exception.ErrorCode;
import com.DeviceManager.Device.Repository.HistoryRepository;
import com.DeviceManager.Device.dto.HistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public History createHistory(HistoryDTO request) {
        History history = new History();
        history.setDate(request.getDate());
        history.setCode(request.getCode());
        history.setPersonLend(request.getPersonLend());
        history.setPersonReceive(request.getPersonReceive());
        history.setNote(request.getNote());
        history.setCurrentArea(request.getCurrentArea());
        return historyRepository.save(history);
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    public History getHistoryById(int id) {
        return historyRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.NOT_FOUND_HISTORY));
    }

    public History updateHistory(HistoryDTO request) {
        History history = new History();
        history.setDate(request.getDate());
        history.setCode(request.getCode());
        history.setPersonLend(request.getPersonLend());
        history.setPersonReceive(request.getPersonReceive());
        history.setNote(request.getNote());
        history.setCurrentArea(request.getCurrentArea());
        return historyRepository.save(history);
    }

    public void deleteHistoryById(int id) {
        History history = getHistoryById(id);
        historyRepository.delete(history);
    }

    public int PageNumberHistory(){
        int PageNumber = (int)Math.ceil((double) historyRepository.getHistoryCount() / 8);
        return PageNumber;
    }

    public List<History> getLimitHistory(int pageNumber) {
        int offset = (pageNumber - 1) * 8;
        return historyRepository.getHistoryLimit(offset);
    }

    public void updateCurrentArea(){
        historyRepository.updateCurrentArea();
    }

    public void returnCurrentArea(String code){
        historyRepository.returnCurrentArea(code);
    }
}
