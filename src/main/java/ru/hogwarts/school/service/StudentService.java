package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentByAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }

    public List<Student> getStudentsBetweenAge(int minAge, int maxAge) {
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    public Integer getCountStudents() {
        return studentRepository.findCountStudents();
    }

    public Double getAverageAgeByStudents() {
        return studentRepository.findAverageAgeByStudents();
    }

    public List<Student> getTop5() {
        return studentRepository.findTop5();
    }

}
