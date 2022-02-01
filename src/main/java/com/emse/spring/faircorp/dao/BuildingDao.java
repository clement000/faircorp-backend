package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface BuildingDao extends JpaRepository<Building, Long> {
    @Query("select c from Building c where c.id=:id")
    Building getById(@Param("id") Long id);
}
