package com.emse.spring.faircorp.api;

import java.util.*;
import java.util.stream.Collectors;

import com.emse.spring.faircorp.dao.*;
import com.emse.spring.faircorp.model.*;

import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heater")
@Transactional
public class HeaterController {
    
    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList()); 
    }

    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the window room
        Room room = roomDao.getById(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), room, dto.getHeaterStatus()));
        }
        else {
            heater = heaterDao.getById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
