package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Grades")
public class Grade {
    @EmbeddedId
    private GradeId id;

    @MapsId("student")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @MapsId("lesson")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson", nullable = false)
    private Schedule lesson;

    @Column(name = "grade_1", columnDefinition = "tinyint")
    private Short grade1;

    @Column(name = "grade_2", columnDefinition = "tinyint")
    private Short grade2;

    public GradeId getId() {
        return id;
    }

    public void setId(GradeId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Schedule getLesson() {
        return lesson;
    }

    public void setLesson(Schedule lesson) {
        this.lesson = lesson;
    }

    public Short getGrade1() {
        return grade1;
    }

    public void setGrade1(Short grade1) {
        this.grade1 = grade1;
    }

    public Short getGrade2() {
        return grade2;
    }

    public void setGrade2(Short grade2) {
        this.grade2 = grade2;
    }

}