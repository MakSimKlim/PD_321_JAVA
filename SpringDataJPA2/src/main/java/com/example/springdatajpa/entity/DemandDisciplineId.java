package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DemandDisciplineId implements Serializable {
    private static final long serialVersionUID = -7285168853222630099L;
    @Column(name = "pending_discipline", nullable = false)
    private Short pendingDiscipline;

    @Column(name = "necessary_discipline", nullable = false)
    private Short necessaryDiscipline;

    public Short getPendingDiscipline() {
        return pendingDiscipline;
    }

    public void setPendingDiscipline(Short pendingDiscipline) {
        this.pendingDiscipline = pendingDiscipline;
    }

    public Short getNecessaryDiscipline() {
        return necessaryDiscipline;
    }

    public void setNecessaryDiscipline(Short necessaryDiscipline) {
        this.necessaryDiscipline = necessaryDiscipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DemandDisciplineId entity = (DemandDisciplineId) o;
        return Objects.equals(this.necessaryDiscipline, entity.necessaryDiscipline) &&
                Objects.equals(this.pendingDiscipline, entity.pendingDiscipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(necessaryDiscipline, pendingDiscipline);
    }

}