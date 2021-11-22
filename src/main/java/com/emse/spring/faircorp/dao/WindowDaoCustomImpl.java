package com.emse.spring.faircorp.dao;

import java.util.*;
import javax.persistence.*;
import com.emse.spring.faircorp.model.*;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public void deleteByRoom(Long id) {
        String jpql = "delete from Window w where w.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Window> findByBuilding(Long id) {
        String jpql = "select w from Window w where w.room.building.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Window> findByRoom(Long id){
        String jpql = "select w from Window w where w.room.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();

    }
}