package ru.morozov.dao;

import ru.morozov.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDAO {
    void update(Student student);

    void save(Student student);

    void add(Student student);

    void delete(Student student);

    Student getStudent(UUID uuid);

    List<Student> getStudents();

    void close();
}
