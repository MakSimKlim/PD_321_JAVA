package com.example.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DemandDisciplines")
public class DemandDiscipline {
    @EmbeddedId
    private DemandDisciplineId id;

    @MapsId("pendingDiscipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pending_discipline", nullable = false)
    private Discipline pendingDiscipline;

    @MapsId("necessaryDiscipline")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "necessary_discipline", nullable = false)
    private Discipline necessaryDiscipline;

    public DemandDisciplineId getId() {
        return id;
    }

    public void setId(DemandDisciplineId id) {
        this.id = id;
    }

    public Discipline getPendingDiscipline() {
        return pendingDiscipline;
    }

    public void setPendingDiscipline(Discipline pendingDiscipline) {
        this.pendingDiscipline = pendingDiscipline;
    }

    public Discipline getNecessaryDiscipline() {
        return necessaryDiscipline;
    }

    public void setNecessaryDiscipline(Discipline necessaryDiscipline) {
        this.necessaryDiscipline = necessaryDiscipline;
    }

}