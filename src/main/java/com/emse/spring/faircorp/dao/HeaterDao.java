package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {
    @Query("select c from Heater c where c.id=:id")
    Heater getById(@Param("id") Long id);
}