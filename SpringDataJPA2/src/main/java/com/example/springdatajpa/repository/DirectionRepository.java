package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction, Short> {
}
