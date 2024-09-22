package ru.hogwarts.school.service;


import java.util.List;

public interface FacultyService<Faculty> {

    List<Faculty> getAll();

    Faculty getById(Long id);

    Faculty save(String name, String color);

    void deleteById(Long id);

    List<Faculty> filterFacultyByColor(String color);

    List<Faculty> filterFacultyByName(String name);
}
