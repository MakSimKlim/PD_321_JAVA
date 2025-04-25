package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DirectionsDisciplinesRelationId implements Serializable {
    private static final long serialVersionUID = -8563745485729816760L;
    @Column(name = "direction", columnDefinition = "tinyint not null")
    private Short direction;

    @Column(name = "discipline", nullable = false)
    private Short discipline;

    public Short getDirection() {
        return direction;
    }

    public void setDirection(Short direction) {
        this.direction = direction;
    }

    public Short getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Short discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DirectionsDisciplinesRelationId entity = (DirectionsDisciplinesRelationId) o;
        return Objects.equals(this.discipline, entity.discipline) &&
                Objects.equals(this.direction, entity.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline, direction);
    }

}