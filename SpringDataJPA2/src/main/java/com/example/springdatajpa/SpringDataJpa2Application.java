package com.example.springdatajpa;

import com.example.springdatajpa.entity.Discipline;
import com.example.springdatajpa.repository.DisciplineRepository;
import com.example.springdatajpa.repository.TeacherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpa2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpa2Application.class, args);
        TeacherRepository teacherRepository = context.getBean(TeacherRepository.class);
        DisciplineRepository disciplineRepository = context.getBean(DisciplineRepository.class);

        //teacherRepository.findAll().forEach(System.out::println);
        teacherRepository.findAll().forEach(teacher -> {
            System.out.println(teacher.toString());
        });

        System.out.println(teacherRepository.findById(3).toString());
        for (Discipline discipline : teacherRepository.findById(3).get().getDisciplines())
        {
            System.out.println(discipline);
        }

    }

}
