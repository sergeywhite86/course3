package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.model.Student;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    void getAllStudents() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/students", List.class))
                .isNotEmpty();
    }

    @Test
    void createStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Jack");
        student.setAge(21);
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/students/", student, Student.class))
                .isNotNull();
    }

    @Test
    void getStudentById() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/students/1", Student.class))
                .isNotNull();
    }

    @Test
    void deleteStudentById() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/students/1", Student.class))
                .isNotNull();
    }

    @Test
    void getStudentsByAge() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/students/filter/15", Student.class))
                .isNotNull();
    }

    @Test
    void getStudentFaculty() {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/students/faculty/1", Student.class))
                .isNotNull();
    }
}