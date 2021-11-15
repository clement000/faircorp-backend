package com.emse.spring.faircorp.api;

import java.util.*;
import java.util.stream.Collectors;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.*;

public class BuildingDto {

    private Long id;
    private String name;
    private Set<String> roomsNames;
    private Set<Long> roomsIds;

    public BuildingDto(){
    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.roomsNames = building.getRooms().stream().map(room -> room.getName()).collect(Collectors.toSet());
        this.roomsIds = building.getRooms().stream().map(room -> room.getId()).collect(Collectors.toSet());
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

    public Set<String> getRoomsNames() {
        return this.roomsNames;
    }

    public void setRoomsNames(Set<String> roomsNames) {
        this.roomsNames = roomsNames;
    }

    public Set<Long> getRoomsIds() {
        return this.roomsIds;
    }

    public void setRoomsIds(Set<Long> roomsIds) {
        this.roomsIds = roomsIds;
    }

}
