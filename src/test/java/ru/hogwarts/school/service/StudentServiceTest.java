package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.hogwarts.school.service.constants.ConstantsForStudentService.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService out;

    @Mock
    private StudentRepository<Student> studentRepository;


    @Test
    void getAll() {
        when(studentRepository.findAll()).thenReturn(STUDENTS);
        List<Student> expected = STUDENTS;
        List<Student> actual = out.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void getById() {
        when(studentRepository.findById(1L)).thenReturn(STUDENT1);
        Student actual = out.getById(1L);
        Student expected = STUDENT1;
        assertEquals(expected, actual);
    }

    @Test
    void save() {
        when(studentRepository.save(STUDENT1.getName(), STUDENT1.getAge())).thenReturn(STUDENT1);
        Student actual = out.save(STUDENT1.getName(), STUDENT1.getAge());
        Student expected = STUDENT1;
        assertEquals(expected, actual);
    }

    @Test
    void deleteById() {
        when(studentRepository.deleteById(1L)).thenReturn(STUDENT1);
        Student actual = out.deleteById(1L);
        Student expected = STUDENT1;
        assertEquals(expected, actual);
    }

    @Test
    void filterByAge() {
        when(studentRepository.filterByAge(19)).thenReturn(STUDENTS_AFTER_FILTER);
        List<Student> expected = STUDENTS_AFTER_FILTER;
        List<Student> actual = out.filterByAge(19);
        assertEquals(expected, actual);
    }
}