package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class DirectionsDisciplinesRelation {
    @EmbeddedId
    private DirectionsDisciplinesRelationId id;

    @MapsId("direction")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direction", nullable = false)
    private Direction direction;

    @MapsId("discipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline", nullable = false)
    private Discipline discipline;

    public DirectionsDisciplinesRelationId getId() {
        return id;
    }

    public void setId(DirectionsDisciplinesRelationId id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}