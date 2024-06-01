package ru.hogwarts.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAll();
    }

    @PostMapping("/add")
    public Faculty createFaculty(@RequestParam String name, @RequestParam String color) {
        return facultyService.save(name, color);
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Faculty deleteFacultyById(@PathVariable Long id) {
        return facultyService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Faculty> filterFacultyByColor(@RequestParam String color) {
        return facultyService.filterFacultyByColor(color);
    }

}
