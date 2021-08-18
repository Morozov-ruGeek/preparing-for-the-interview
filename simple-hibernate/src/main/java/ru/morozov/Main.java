package ru.morozov;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.morozov.dao.StudentDAO;
import ru.morozov.dao.impl.StudentDAOImpl;
import ru.morozov.entity.Student;

import javax.persistence.EntityManager;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            em.persist(new Student(String.format("studentUUID_%d", i)));
        }
        em.getTransaction().commit();
        em.close();

        StudentDAO dao = new StudentDAOImpl(sessionFactory.openSession());

        System.out.println(
                "getStudent = "
                        + dao.getStudent(UUID.fromString("91ffdc89-a814-4c44-81e4-0d7947a155b2")).

                        getName());

        Student student = dao.getStudent(UUID.fromString("91ffdc89-a814-4c44-81e4-0d7947a155b2"));
        dao.delete(student);

        student = dao.getStudent(UUID.fromString("7246fbf5-1b29-423a-85c8-f44ee99d06e1"));

        student.setName("new_name");
        dao.save(student);

        final Student resultStudent = dao.getStudents().stream()
                .filter(student1 -> student1.getName().equals("new_name")).findFirst().get();
        dao.close();
        System.out.println("resultStudent.getId() = " + resultStudent.getId());
        System.out.println("resultStudent.getName() = " + resultStudent.getName());
    }
}
