package ru.hogwarts.school.repository;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FacultyRepository<Faculty> {

   List<Faculty> findAll();

    Faculty findById(Long id);

    Faculty save(String name,String color);

    Faculty deleteById(Long id);

    List<Faculty> filterByColor(String color);
}
