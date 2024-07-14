package ru.hogwarts.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @PostMapping("/add")
    public Student createStudent(@RequestParam String name, @RequestParam Integer age) {
        return studentService.save(name, age);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByAge(@RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) Integer min,
                                          @RequestParam(required = false) Integer max) {
        if (age != null) {
            return studentService.getStudentByAge(age);
        }
        if (min != null && max != null) {
           return studentService.getStudentsBetweenAge(min, max);
        }
        return new ArrayList<>();
    }

    @GetMapping("/faculty/{id}")
    public Faculty getStudentFaculty(@PathVariable Long id) {
        return studentService.getById(id).getFaculty();
    }

}
