package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Directions")
public class Direction {
    @Id
    //@Column(name = "direction_id", columnDefinition = "tinyint not null")
    @Column(name = "direction_id", nullable = false)
    private Short id;

    @Nationalized
    @Column(name = "direction_name", length = 50)
    private String directionName;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

}