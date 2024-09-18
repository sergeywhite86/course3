package ru.hogwarts.school.service.mockServiceImpl;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@Profile("mock")
public class MockFacultyService implements FacultyService<Faculty> {

    @Override
    public List<Faculty> getAll() {
        log.info("MockFacultyService.getAll()");
        return new ArrayList<>();
    }

    @Override
    public Faculty getById(Long id) {
        log.info("MockFacultyService.getById()");
        return new Faculty();
    }

    @Override
    public Faculty save(String name, String color) {
        log.info("MockFacultyService.save()");
        return new Faculty();
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete faculty by id: {}", id);
    }

    @Override
    public List<Faculty> filterFacultyByColor(String color) {
        log.info("MockFacultyService.filterFacultyByColor()");
        return new ArrayList<>();
    }

    @Override
    public List<Faculty> filterFacultyByName(String name) {
        log.info("MockFacultyService.filterFacultyByName()");
        return new ArrayList<>();
    }
}
