package ru.hogwarts.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.repository.impl.StudentRepositoryImpl;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    StudentRepository<Student> studentRepository = new StudentRepositoryImpl();


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(String name, Integer age) {
        return studentRepository.save(name, age);
    }

    public Student deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    public List<Student> filterByAge(int age) {
        return studentRepository.filterByAge(age);
    }

}
