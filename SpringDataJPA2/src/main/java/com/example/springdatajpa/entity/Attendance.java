package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
public class Attendance {
    @EmbeddedId
    private AttendanceId id;

    @MapsId("student")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student", nullable = false)
    private Student student;

    @MapsId("lesson")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson", nullable = false)
    private Schedule lesson;

    @Column(name = "present", nullable = false)
    private Boolean present = false;

    public AttendanceId getId() {
        return id;
    }

    public void setId(AttendanceId id) {
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

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

}