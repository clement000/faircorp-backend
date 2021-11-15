package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
    @Query("select c from Room c where c.id=:id")
    Room getById(@Param("id") Long id);

    @Query("select c from Room c where c.name=:name")
    Room findByName(@Param("name") String name);
}