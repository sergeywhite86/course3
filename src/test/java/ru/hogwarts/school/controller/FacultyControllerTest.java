package ru.hogwarts.school.controller;

import jakarta.annotation.PostConstruct;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = FacultyController.class)
class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    private Faculty faculty;
    private final Long id = 1L;
    private final String name = "java";
    private final String color = "red";
    private final Set<Student> students = Set.of(new Student());

    @PostConstruct
    private void postConstruct() {
        faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);
        faculty.setStudents(students);

    }


    @Test
    void shouldGetAllFacultyIsOk() throws Exception {
        when(facultyRepository.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/faculty"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateFacultyIsOk() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faculty.getName());
        jsonObject.put("color", faculty.getColor());

        when(facultyRepository.save(any())).thenReturn(faculty);

        mockMvc.perform(
                        post("/faculty/add?name=" + name + "&color=" + color)
                                .content(jsonObject.toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

    }

    @Test
    void shouldGetFacultyByIdIsOk() throws Exception {
        when(facultyRepository.findById(any())).thenReturn(Optional.of(faculty));
        mockMvc.perform(
                        get("/faculty/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));

    }

    @Test
    void deleteFacultyByIdIsOk() throws Exception {
        mockMvc.perform(
                        delete("/faculty/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFilterFacultyWithTwoParamIsOk() throws Exception {
        when(facultyRepository.findFacultiesByColorIgnoreCase("red")).thenReturn(List.of(faculty));
        when(facultyRepository.findFacultiesByNameIgnoreCase("java")).thenReturn(List.of(faculty));

        mockMvc.perform(
                        get("/faculty/filter?color=red&name=java")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    void shouldGetFacultyStudentsIsOk() throws Exception {
        when(facultyRepository.findById(any())).thenReturn(Optional.of(faculty));
        mockMvc.perform(
                        get("/faculty/1/students")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andExpect(status().isOk());

    }
}