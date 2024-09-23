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

    private final StudentService<Student> studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/count")
    public Integer getAllStudentsCount() {
        return studentService.getCountStudents();
    }

    @GetMapping("/avgAge")
    public Double getAverageAge() {
        return studentService.getAverageAgeByStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/topFive")
    public List<Student> getTop5Students() {
        return studentService.getTop5();
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

    @PostMapping("/add")
    public Student createStudent(@RequestParam String name, @RequestParam Integer age) {
        return studentService.save(name, age);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/start_A")
    public List<String> getStudentsStartA() {
        return studentService.getStudentsStartWitnA();
    }

    @GetMapping("/averageAge")
    public Double getStudentsAverageAge() {
        return studentService.getAverageAgeByStudents();
    }

    @GetMapping("hw6Task1")
    public void hwFive6Task1() {
        List<Student> students = studentService.getAll();

        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());

        new Thread(() -> {
            System.out.println(students.get(2).getName());
            System.out.println(students.get(3).getName());
        }).start();


        new Thread(() -> {
            System.out.println(students.get(4).getName());
            System.out.println(students.get(5).getName());
        }).start();
    }

    @GetMapping("hw6Task2")
    public void hwFive6Task2() {
        List<Student> students = studentService.getAll();

        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());

        new Thread(() -> {
            printName(students.get(2).getName());
            printName(students.get(3).getName());
        }).start();

        new Thread(() -> {
            printName(students.get(4).getName());
            printName(students.get(5).getName());
        }).start();
    }

    public synchronized void printName(String name) {
        System.out.println(name);
    }
}

