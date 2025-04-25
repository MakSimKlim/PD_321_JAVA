package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeachersDisciplinesRelationId implements Serializable {
    private static final long serialVersionUID = 3660176414459385752L;
    @Column(name = "teacher", nullable = false)
    private Integer teacher;

    @Column(name = "discipline", nullable = false)
    private Short discipline;

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
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
        TeachersDisciplinesRelationId entity = (TeachersDisciplinesRelationId) o;
        return Objects.equals(this.teacher, entity.teacher) &&
                Objects.equals(this.discipline, entity.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, discipline);
    }

}