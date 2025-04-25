package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class SpecialitiesDirectionsRelation {
    @EmbeddedId
    private SpecialitiesDirectionsRelationId id;

    @MapsId("direction")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direction", nullable = false)
    private Direction direction;

    @MapsId("speciality")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;

    public SpecialitiesDirectionsRelationId getId() {
        return id;
    }

    public void setId(SpecialitiesDirectionsRelationId id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}