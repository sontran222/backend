package com.DeviceManager.Device.dto;

import java.time.LocalDate;

public class HistoryDTO {
    private LocalDate date;
    private String code;
    private String personLend;
    private String personReceive;
    private String note;
    private String currentArea;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPersonLend() {
        return personLend;
    }

    public void setPersonLend(String personLend) {
        this.personLend = personLend;
    }

    public String getPersonReceive() {
        return personReceive;
    }

    public void setPersonReceive(String personReceive) {
        this.personReceive = personReceive;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(String currentArea) {
        this.currentArea = currentArea;
    }
}
