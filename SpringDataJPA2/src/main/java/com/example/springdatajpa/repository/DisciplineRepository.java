package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Short> {
}
