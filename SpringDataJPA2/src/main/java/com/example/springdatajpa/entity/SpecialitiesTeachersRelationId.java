package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpecialitiesTeachersRelationId implements Serializable {
    private static final long serialVersionUID = -8228488428263885706L;
    @Column(name = "speciality", nullable = false)
    private Short speciality;

    @Column(name = "teacher", nullable = false)
    private Integer teacher;

    public Short getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Short speciality) {
        this.speciality = speciality;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SpecialitiesTeachersRelationId entity = (SpecialitiesTeachersRelationId) o;
        return Objects.equals(this.speciality, entity.speciality) &&
                Objects.equals(this.teacher, entity.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speciality, teacher);
    }

}