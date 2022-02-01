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
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

public RoomController(RoomDao roomDao, BuildingDao buildingDao, WindowDao windowDao, HeaterDao heaterDao){
    this.roomDao = roomDao;
    this.buildingDao = buildingDao;
    this.windowDao = windowDao;
    this.heaterDao = heaterDao;
}

    @GetMapping
    @CrossOrigin
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList()); 
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin
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

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteByRoom(id);
        heaterDao.deleteByRoom(id);
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switchWindows")
    public void switchWindows(@PathVariable Long id){
        List<Window> windows = windowDao.findByRoom(id);
        for (Window window : windows){
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public void switchHeaters(@PathVariable Long id){
        List<Heater> heaters = heaterDao.findByRoom(id);
        for (Heater heater : heaters){
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
    }
}
