package ru.hogwarts.school.repository.repo;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
@Getter
@Component
public class InMemoryStudentDB {

    private final Map<Long, Student> studentsDB = new HashMap<>();

    public static long id;
}
