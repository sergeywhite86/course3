package ru.hogwarts.school.service.constants;

import ru.hogwarts.school.model.Student;


import java.util.List;


public class ConstantsForStudentService {

    public static final Student STUDENT1 = new Student(1L, "Mike", 19);
    public static final Student STUDENT2 = new Student(2L, "John", 29);
    public static final Student STUDENT3 = new Student(3L, "Mila", 25);

    public static final List<Student> STUDENTS = List.of(STUDENT1, STUDENT2, STUDENT3);
    public static final List<Student> STUDENTS_AFTER_FILTER = List.of(STUDENT1);


}
