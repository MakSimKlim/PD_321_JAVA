package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CompleteDisciplines")
public class CompleteDiscipline {
    @EmbeddedId
    private CompleteDisciplineId id;

    @MapsId("group")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"group\"", nullable = false)
    private Group group;

    @MapsId("discipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline", nullable = false)
    private Discipline discipline;

    public CompleteDisciplineId getId() {
        return id;
    }

    public void setId(CompleteDisciplineId id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}