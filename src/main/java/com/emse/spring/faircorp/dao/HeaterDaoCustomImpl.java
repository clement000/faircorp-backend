package com.emse.spring.faircorp.dao;

import java.util.List;

import javax.persistence.*;

import com.emse.spring.faircorp.model.Heater;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void deleteByRoom(Long id) {
        String jpql = "delete from Heater h where h.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Heater> findByBuilding(Long id) {
        String jpql = "select h from Heater h where h.room.building.id = :id";
        return em.createQuery(jpql, Heater.class)
            .setParameter("id", id)
            .getResultList();
    }

    @Override
    public List<Heater> findByRoom(Long id) {
        String jpql = "select h from Heater h where h.room.id = :id";
        return em.createQuery(jpql, Heater.class)
            .setParameter("id", id)
            .getResultList();
    }
}