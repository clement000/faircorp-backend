package com.emse.spring.faircorp.dao;

import java.util.*;
import com.emse.spring.faircorp.model.Room;

public interface RoomDaoCustom {
    List<Room> findByBuilding(Long id);
}