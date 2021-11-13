package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {
    @Query("select c from Window c where c.id=:id")
    Window getById(@Param("id") Long id);
}