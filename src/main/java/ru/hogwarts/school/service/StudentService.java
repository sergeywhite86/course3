package ru.hogwarts.school.service;


import java.util.List;

public interface StudentService<Student> {

    List<Student> getAll();

    Student getById(Long id);

    Student save(String name, Integer age);

    void deleteById(Long id);

    List<Student> getStudentByAge(int age);

    List<Student> getStudentsBetweenAge(int minAge, int maxAge);

    Integer getCountStudents();

    Double getAverageAgeByStudents();

    List<Student> getTop5();

}
