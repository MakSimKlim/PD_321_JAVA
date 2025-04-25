package com.example.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompleteDisciplineId implements Serializable {
    private static final long serialVersionUID = 8056289797667779334L;
    @Column(name = "\"group\"", nullable = false)
    private Integer group;

    @Column(name = "discipline", nullable = false)
    private Short discipline;

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
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
        CompleteDisciplineId entity = (CompleteDisciplineId) o;
        return Objects.equals(this.discipline, entity.discipline) &&
                Objects.equals(this.group, entity.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline, group);
    }

}