package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class SpecialitiesDisciplinesRelation {
    @EmbeddedId
    private SpecialitiesDisciplinesRelationId id;

    @MapsId("speciality")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;

    @MapsId("discipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline", nullable = false)
    private Discipline discipline;

    public SpecialitiesDisciplinesRelationId getId() {
        return id;
    }

    public void setId(SpecialitiesDisciplinesRelationId id) {
        this.id = id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}