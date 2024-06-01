package ru.hogwarts.school.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.repo.InMemoryFacultyDB;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Repository
public class FacultyRepositoryImpl implements FacultyRepository<Faculty> {

    private final InMemoryFacultyDB inMemoryFacultyDB;

    @Override
    public List<Faculty> findAll() {
        return new ArrayList<>(inMemoryFacultyDB.getFacultyDB().values());
    }

    @Override
    public Faculty findById(Long id) {
        return inMemoryFacultyDB.getFacultyDB().get(id);
    }

    @Override
    public Faculty save(String name, String color) {
        Long id = ++InMemoryFacultyDB.id;
        Faculty faculty = new Faculty(id, name, color);
        inMemoryFacultyDB.getFacultyDB().put(id, faculty);
        return faculty;
    }

    @Override
    public Faculty deleteById(Long id) {
        inMemoryFacultyDB.getFacultyDB().remove(id);
        return inMemoryFacultyDB.getFacultyDB().get(id);
    }

    @Override
    public List<Faculty> filterByColor(String color) {
        return findAll().stream().filter(f -> f.getColor().equals(color)).toList();
    }
}
