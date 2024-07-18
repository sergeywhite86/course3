package ru.hogwarts.school.service.constants;

import ru.hogwarts.school.model.Faculty;


import java.util.List;


public class ConstantsForFacultyService {

    public static final Faculty FACULTY1 = new Faculty(1L, "java", "green");
    public static final Faculty FACULTY2 = new Faculty(2L, "python", "red");
    public static final Faculty FACULTY3 = new Faculty(3L, "js", "blue");

    public static final List<Faculty> FACULTIES = List.of(FACULTY1,FACULTY2, FACULTY3);

    public static final List<Faculty> FACULTIES_AFTER_FILTER = List.of(FACULTY1);
}
