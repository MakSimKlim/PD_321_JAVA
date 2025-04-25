package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class SpecialitiesTeachersRelation {
    @EmbeddedId
    private SpecialitiesTeachersRelationId id;

    @MapsId("speciality")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speciality", nullable = false)
    private Speciality speciality;

    @MapsId("teacher")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher", nullable = false)
    private Teacher teacher;

    public SpecialitiesTeachersRelationId getId() {
        return id;
    }

    public void setId(SpecialitiesTeachersRelationId id) {
        this.id = id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}