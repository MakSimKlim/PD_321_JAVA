package com.example.springdatajpa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Disciplines")
public class Discipline {
    @Id
    @Column(name = "discipline_id", nullable = false)
    private Short id;

    @Nationalized
    @Column(name = "discipline_name", nullable = false, length = 150)
    private String disciplineName;

    @Column(name = "number_of_lessons", columnDefinition = "tinyint not null")
    private Short numberOfLessons;

    @ManyToMany
    @JoinTable(name = "TeachersDisciplinesRelation",
            joinColumns = @JoinColumn(name = "discipline"),
            inverseJoinColumns = @JoinColumn(name = "teacher"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Short getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(Short numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}