package ru.morozov.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.morozov.dao.StudentDAO;
import ru.morozov.entity.Student;

import java.util.List;
import java.util.UUID;

public class StudentDAOImpl implements StudentDAO {
    Session session;

    public StudentDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Student student) {
        add(student);
    }

    @Override
    public void add(Student student) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(student);
        tx.commit();
    }

    @Override
    public void delete(Student student) {
        Transaction tx = session.beginTransaction();
        session.remove(student);
        tx.commit();
    }

    @Override
    public void update(Student student) {
        add(student);
    }

    @Override
    public Student getStudent(UUID uuid) {
        return session.get(Student.class, uuid);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) session.createQuery("from Student").list();
    }

    @Override
    public void close() {
        session.close();
    }
}
