package com.emse.spring.faircorp.api;

import java.util.*;
import java.util.stream.Collectors;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;

import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
@Transactional
public class BuildingController {
    
    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final HeaterDao heaterDao;
    private final BuildingDao buildingDao;

    public BuildingController(WindowDao windowDao, RoomDao roomDao, HeaterDao heaterDao, BuildingDao buildingDao){
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll(){
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName(), new HashSet<>(roomDao.findAllById(dto.getRoomsIds()))));
        }
        else {
            building = buildingDao.getById(dto.getId());
        }
        return new BuildingDto(building);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteAll(windowDao.findByBuilding(id));
        heaterDao.deleteAll(heaterDao.findByBuilding(id));
        roomDao.deleteAll(roomDao.findByBuilding(id));
        buildingDao.deleteById(id);
    }
}
