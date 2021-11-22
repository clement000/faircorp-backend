package com.emse.spring.faircorp.api;

import java.util.*;
import java.util.stream.Collectors;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;

import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@Transactional
public class RoomController {
    
    private final RoomDao roomDao;
    private final BuildingDao buildingDao;

public RoomController(RoomDao roomDao, BuildingDao buildingDao){
    this.roomDao = roomDao;
    this.buildingDao = buildingDao;
}

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList()); 
    }

@GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        // RoomDto must always contain the room Building
        Room room = null;
        Building building = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            building = buildingDao.getById(dto.getBuildingId());
            room = roomDao.save(new Room(dto.getFloor(), dto.getName(), dto.getCurrentTemperature(), dto.getTargetTemperature(), building));
        }
        else {
            room = roomDao.getById(dto.getId());
        }
        return new RoomDto(room);
    }
}
