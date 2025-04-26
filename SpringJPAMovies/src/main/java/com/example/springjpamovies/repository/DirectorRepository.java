package com.example.springjpamovies.repository;

import com.example.springjpamovies.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
