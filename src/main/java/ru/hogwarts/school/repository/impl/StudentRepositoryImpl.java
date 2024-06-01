package ru.hogwarts.school.repository.impl;

import org.springframework.stereotype.Repository;

import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.repository.repo.InMemoryStudentDB;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepositoryImpl implements StudentRepository<Student> {

    InMemoryStudentDB studentDB = new InMemoryStudentDB();


    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentDB.getStudentsDB().values());
    }

    @Override
    public Student findById(Long id) {
        return studentDB.getStudentsDB().get(id);
    }

    @Override
    public Student save(String name, Integer age) {
        long id = ++InMemoryStudentDB.id;
        Student student = new Student(id, name, age);
        studentDB.getStudentsDB().put(id, student);
        return student;
    }

    @Override
    public Student deleteById(Long id) {
        Student student = findById(id);
        studentDB.getStudentsDB().remove(id);
        return student;
    }

    @Override
    public List<Student> filterByAge(int age) {
        return findAll().stream().filter(s -> s.getAge() == age).toList();
    }

}
