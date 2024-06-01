package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository<Faculty> facultyRepository;

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty save(String name, String color) {
        return facultyRepository.save(name, color);
    }

    public Faculty deleteById(Long id) {
        return facultyRepository.deleteById(id);
    }

    public List<Faculty> filterFacultyByColor(String color) {
        return facultyRepository.filterByColor(color);
    }

}
