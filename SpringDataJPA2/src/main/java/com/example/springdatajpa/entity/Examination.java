package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Examinations")
public class Examination {
    @EmbeddedId
    private ExaminationId id;

    @MapsId("student")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @MapsId("lesson")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson", nullable = false)
    private Schedule lesson;

    @Column(name = "grade", columnDefinition = "tinyint")
    private Short grade;

    public ExaminationId getId() {
        return id;
    }

    public void setId(ExaminationId id) {
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

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

}