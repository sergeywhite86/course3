package ru.hogwarts.school.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;


import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Profile("!mock")
public class StudentServiceImpl implements StudentService<Student> {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        log.info("Get all students");
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        log.info("Get student by id: {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(String name, Integer age) {
        log.info("Save student with name: {}", name);
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete student by id: {}", id);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        log.info("Get student by age: {}", age);
        return studentRepository.findStudentsByAge(age);
    }

    @Override
    public List<Student> getStudentsBetweenAge(int minAge, int maxAge) {
        log.info("Get student between ages: {}", minAge);
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    @Override
    public Integer getCountStudents() {
        log.info("Get student count");
        return studentRepository.findCountStudents();
    }

    @Override
    public Double getAverageAgeByStudents() {
        log.info("Get student average age");
        return studentRepository.findAverageAgeByStudents();
    }

    @Override
    public List<Student> getTop5() {
        log.info("Get top 5 students");
        return studentRepository.findTop5();
    }

    @Override
    public List<String> getStudentsStartWitnA(){
        log.info("Get student start with A");
        return studentRepository.findAll().stream()
                .filter(s->s.getName().startsWith("A"))
                .sorted(Comparator.comparing(Student::getName))
                .map(student -> student.getName().toUpperCase())
                .toList();
    }

    @Override
    public Double gerAverageAge() {
        log.info("Get student average age");
        return studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

}
