package ru.hogwarts.school.service.mockServiceImpl;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;


import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@Profile("mock")
public class MockStudentService implements StudentService<Student> {

    @Override
    public List<Student> getAll() {
        log.info("MockStudentService.getAll()");
        return new ArrayList<>();
    }

    @Override
    public Student getById(Long id) {
        log.info("MockStudentService.getById()");
        return new Student();
    }

    @Override
    public Student save(String name, Integer age) {
        log.info("MockStudentService.save()");
        return new Student();
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete student by id: {}", id);
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        log.info("MockStudentService.getStudentByAge()");
        return new ArrayList<>();
    }

    @Override
    public List<Student> getStudentsBetweenAge(int minAge, int maxAge) {
        log.info("MockStudentService.getStudentsBetweenAge()");
        return new ArrayList<>();
    }

    @Override
    public Integer getCountStudents() {
        return 0;
    }

    @Override
    public Double getAverageAgeByStudents() {
        return 0.0;
    }

    @Override
    public List<Student> getTop5() {
        return new ArrayList<>();
    }
}
