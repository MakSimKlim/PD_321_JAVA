package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class TeachersDisciplinesRelation {
    @EmbeddedId
    private TeachersDisciplinesRelationId id;

    @MapsId("teacher")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher", nullable = false)
    private Teacher teacher;

    @MapsId("discipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline", nullable = false)
    private Discipline discipline;

    public TeachersDisciplinesRelationId getId() {
        return id;
    }

    public void setId(TeachersDisciplinesRelationId id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}