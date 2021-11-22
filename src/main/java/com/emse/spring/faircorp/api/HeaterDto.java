package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.*;

public class HeaterDto {

    private Long id;
    private Long power;
    private String name;
    private Long roomId;
    private String roomName;
    private HeaterStatus heaterStatus;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.power = heater.getPower();
        this.name = heater.getName();
        this.roomName = heater.getRoom().getName();
        this.roomId = heater.getRoom().getId();
        this.heaterStatus = heater.getHeaterStatus();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return this.power;
    }

    public void setPower(Long power) {
        this.power = power;
    }
    
    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public HeaterStatus getHeaterStatus() {
        return this.heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
