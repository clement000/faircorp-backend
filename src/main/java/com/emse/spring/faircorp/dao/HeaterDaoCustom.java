package com.emse.spring.faircorp.dao;

import java.util.*;
import com.emse.spring.faircorp.model.Heater;

public interface HeaterDaoCustom {
    void deleteByRoom(Long id);

    List<Heater> findByBuilding(Long id);

    List<Heater> findByRoom(Long id);
}