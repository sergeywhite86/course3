package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty save(String name, String color) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setColor(color);
        return facultyRepository.save(faculty);
    }

    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> filterFacultyByColor(String color) {
        return facultyRepository.findFacultiesByColor(color);
    }

}
