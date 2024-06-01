package ru.hogwarts.school.repository.repo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
@RequiredArgsConstructor
public class InMemoryFacultyDB {

    private final Map<Long, Faculty> FacultyDB = new HashMap<>();

    public static long id ;
}
