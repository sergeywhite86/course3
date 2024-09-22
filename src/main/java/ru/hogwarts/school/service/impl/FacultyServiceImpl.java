package ru.hogwarts.school.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Profile("!mock")
public class FacultyServiceImpl implements FacultyService<Faculty> {

    private final FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAll() {
        log.info("Getting all faculties");
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getById(Long id) {
        log.info("Getting faculty by id: {}", id);
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public Faculty save(String name, String color) {
        log.info("Saving faculty: {}", name);
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setColor(color);
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting faculty by id: {}", id);
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> filterFacultyByColor(String color) {
        log.info("Filtering faculty by color: {}", color);
        return facultyRepository.findFacultiesByColorIgnoreCase(color);
    }

    @Override
    public List<Faculty> filterFacultyByName(String name) {
        log.info("Filtering faculty by name: {}", name);
        return facultyRepository.findFacultiesByNameIgnoreCase(name);
    }

    @Override
    public String getMostLongFacultyName() {
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

}
