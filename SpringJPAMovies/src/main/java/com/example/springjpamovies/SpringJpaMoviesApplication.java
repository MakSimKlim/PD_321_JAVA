package com.example.springjpamovies;

import com.example.springjpamovies.repository.DirectorRepository;
import com.example.springjpamovies.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaMoviesApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SpringJpaMoviesApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringJpaMoviesApplication.class, args);
		DirectorRepository directorRepository = context.getBean(DirectorRepository.class);
		MovieRepository movieRepository = context.getBean(MovieRepository.class);
		directorRepository.findAll().forEach(System.out::println);

	}

}
