package com.emse.spring.faircorp.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building(){
    }

    public Building(String name, Set<Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
