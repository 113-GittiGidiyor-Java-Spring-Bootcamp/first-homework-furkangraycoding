package dev.patika.service;

import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {


    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {

        return em.createQuery("select s from Student s",Student.class).getResultList();
    }


    @Override
    public Student findById(int id) {

        return em.find(Student.class,id);
    }

    @Override
    public void saveToDatabase(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

    }

    @Override
    public void deleteFromDatabase(String name) {
        em.getTransaction().begin();
        Student student= em.createQuery("from Student s where s.name =:name ",Student.class).setParameter("name",name).getSingleResult();
        em.remove(student);
        em.getTransaction().commit();

    }

    @Override
    public void updateOnDatabase(String name, String address) {
        em.getTransaction().begin();
        Student student= em.createQuery("from Student s where s.name =:name ",Student.class).setParameter("name",name).getSingleResult();
        em.remove(student);
        student.setAddress(address);
        em.persist(student);
        em.getTransaction().commit();

    }
}
