package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table
public class Heater {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long power;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Room room;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, Room room, HeaterStatus heaterStatus, Long power) {
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
        this.power = power;
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

    public Long getPower() {
        return this.power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return this.heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
