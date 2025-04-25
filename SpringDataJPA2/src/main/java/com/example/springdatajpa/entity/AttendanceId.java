package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendanceId implements Serializable {
    private static final long serialVersionUID = -146579956728247590L;
    @Column(name = "student", nullable = false)
    private Integer student;

    @Column(name = "lesson", nullable = false)
    private Long lesson;

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Long getLesson() {
        return lesson;
    }

    public void setLesson(Long lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AttendanceId entity = (AttendanceId) o;
        return Objects.equals(this.student, entity.student) &&
                Objects.equals(this.lesson, entity.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, lesson);
    }

}