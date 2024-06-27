package ru.hogwarts.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

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
    public void deleteFacultyById(@PathVariable Long id) {
         studentService.deleteById(id);
    }

    @GetMapping("/filter/{age}")
    public List<Student> getStudentsByAge(@PathVariable Integer age) {
        return studentService.filterByAge(age);
    }

}
