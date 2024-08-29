package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAge(int age);

    List<Student> findStudentsByAgeBetween(int minAge, int maxAge);

    @Query(value = "SELECT COUNT(student) AS students_count FROM student", nativeQuery = true)
    Integer findCountStudents();

    @Query(value = "SELECT AVG(age) AS average_age FROM student", nativeQuery = true)
    Double findAverageAgeByStudents();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> findTop5();

}
