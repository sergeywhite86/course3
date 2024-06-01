package ru.hogwarts.school.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository<Student> {

    List<Student> findAll();

    Student findById(Long id);

    Student save(String name, Integer age);

    Student deleteById(Long id);

    List<Student> filterByAge(int age);
}
