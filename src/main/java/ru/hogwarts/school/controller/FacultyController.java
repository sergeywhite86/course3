package ru.hogwarts.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService<Faculty> facultyService;

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
    public void deleteFacultyById(@PathVariable Long id) {
        facultyService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Faculty> filterFaculty(@RequestParam(required = false) String color,
                                       @RequestParam(required = false) String name) {
        if (color != null) {
            return facultyService.filterFacultyByColor(color);
        }
        if (name != null) {
            return facultyService.filterFacultyByName(name);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{id}/students")
    public Set<Student> getFacultyStudents(@PathVariable Long id) {
        return facultyService.getById(id).getStudents();
    }

    @GetMapping("/maxName")
    public String getMaxName() {
        return facultyService.getMostLongFacultyName();
    }

    @GetMapping("hw5")
    public Integer hwFive(){
        return Stream.iterate(1, a -> a +1) .limit(1_000_000).parallel() .reduce(0, Integer::sum);
    }
}
