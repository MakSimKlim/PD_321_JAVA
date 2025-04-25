package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialitiesDisciplinesRelationId implements Serializable {
    private static final long serialVersionUID = -4682519858781169793L;
    @Column(name = "speciality", nullable = false)
    private Short speciality;

    @Column(name = "discipline", nullable = false)
    private Short discipline;

    public Short getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Short speciality) {
        this.speciality = speciality;
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
        SpecialitiesDisciplinesRelationId entity = (SpecialitiesDisciplinesRelationId) o;
        return Objects.equals(this.speciality, entity.speciality) &&
                Objects.equals(this.discipline, entity.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciality, discipline);
    }

}