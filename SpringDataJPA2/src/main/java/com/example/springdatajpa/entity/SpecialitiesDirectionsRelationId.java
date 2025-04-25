package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialitiesDirectionsRelationId implements Serializable {
    private static final long serialVersionUID = 2454681958640788904L;
    @Column(name = "direction", columnDefinition = "tinyint not null")
    private Short direction;

    @Column(name = "speciality", nullable = false)
    private Short speciality;

    public Short getDirection() {
        return direction;
    }

    public void setDirection(Short direction) {
        this.direction = direction;
    }

    public Short getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Short speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SpecialitiesDirectionsRelationId entity = (SpecialitiesDirectionsRelationId) o;
        return Objects.equals(this.speciality, entity.speciality) &&
                Objects.equals(this.direction, entity.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciality, direction);
    }

}