package ru.hogwarts.school.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.hogwarts.school.service.constants.ConstantsForFacultyService.*;


@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {

    @InjectMocks
    private FacultyService out;

    @Mock
    private FacultyRepository<Faculty> facultyRepository;


    @Test
    void getAll() {
        when(facultyRepository.findAll()).thenReturn(FACULTIES);
        List<Faculty> expected = FACULTIES;
        List<Faculty> actual = out.getAll();
        assertEquals(expected, actual);

    }

    @Test
    void getById() {
        when(facultyRepository.findById(1L)).thenReturn(FACULTY1);
        Faculty actual = out.getById(1L);
        Faculty expected = FACULTY1;
        assertEquals(expected, actual);
    }

    @Test
    void save() {
        when(facultyRepository.save(FACULTY1.getName(), FACULTY1.getColor())).thenReturn(FACULTY1);
        Faculty actual = out.save(FACULTY1.getName(), FACULTY1.getColor());
        Faculty expected = FACULTY1;
        assertEquals(expected, actual);
    }

    @Test
    void deleteById() {
        when(facultyRepository.deleteById(1L)).thenReturn(FACULTY1);
        Faculty actual = out.deleteById(1L);
        Faculty expected = FACULTY1;
        assertEquals(expected, actual);
    }

    @Test
    void filterFacultyByColor() {
        when(facultyRepository.filterByColor("green")).thenReturn(FACULTIES_AFTER_FILTER);
        List<Faculty> actual = out.filterFacultyByColor("green");
        List<Faculty> expected = FACULTIES_AFTER_FILTER;
        assertEquals(expected, actual);
    }
}