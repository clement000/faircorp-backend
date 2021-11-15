package com.emse.spring.faircorp.dao;

import java.util.List;

import javax.persistence.*;

import com.emse.spring.faircorp.model.Room;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findByBuilding(Long id) {
        String jpql = "select r from Room r where r.building.id = :id";
        return em.createQuery(jpql, Room.class)
            .setParameter("id", id)
            .getResultList();
    }
}