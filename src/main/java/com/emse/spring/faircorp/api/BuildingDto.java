package com.emse.spring.faircorp.api;

import java.util.*;

import com.emse.spring.faircorp.model.*;

public class BuildingDto {

    private Long id;
    private String name;
    private Set<Room> rooms;

    public BuildingDto(){
    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
        this.rooms = building.getRooms();
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

    public Set<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
