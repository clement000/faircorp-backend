package com.emse.spring.faircorp.dao;

import java.util.*;
import com.emse.spring.faircorp.model.Window;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

    void deleteByRoom(Long id);

    List<Window> findByBuilding(Long id);

    List<Window> findByRoom(Long id);
}