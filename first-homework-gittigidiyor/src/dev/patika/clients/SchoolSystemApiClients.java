package dev.patika.clients;

import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

public class SchoolSystemApiClients {
    public static void main(String[] args) {
        saveTestData();
    }

    private static void saveTestData(){

        Student student1 = new Student("Koray", LocalDate.of(2021, Month.APRIL,22),"address1","male");
        Student student2 = new Student("Levent", LocalDate.of(2018, Month.MARCH,11),"address2","male");
        Student student3 = new Student("Selen", LocalDate.of(2019, Month.AUGUST,16),"address3","female");

        Instructor instructor0= new Instructor("Selim","address0",222333444);
        Instructor instructor01= new Instructor("muhittin","address01",666222111);

        Instructor perinstructor1= new PermanentInstructor("Furkan","address1",539570,10.50);
        Instructor perinstructor11= new PermanentInstructor("tuncel","address11",111666222,12.6);

        Instructor visitinstructor2= new VisitingResearcher("Betül","address2",555666777,4250);
        Instructor visitinstructor22= new VisitingResearcher("Merve","address22",1516161,5550);


        Course course1=new Course("Chem-1","Chm101",6);
        Course course2=new Course("Chem-2","Chm301",8);
        Course course3=new Course("Chem-3","Chm201",10);



        course1.setInstructor(instructor0);
        course2.setInstructor(perinstructor11);
        course3.setInstructor(visitinstructor22);


        student1.getStudentCourses().add(course1);
        student2.getStudentCourses().add(course2);
        student3.getStudentCourses().add(course3);

        course1.getStudentList().add(student1);
        course2.getStudentList().add(student2);
        course3.getStudentList().add(student3);

        visitinstructor22.getInstructorCoursesList().add(course1);
        perinstructor11.getInstructorCoursesList().add(course2);
        instructor01.getInstructorCoursesList().add(course3);


        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor0);
            em.persist(instructor01);
            em.persist(perinstructor1);
            em.persist(perinstructor11);
            em.persist(visitinstructor2);
            em.persist(visitinstructor2);


            em.persist(student1);
            em.persist(student2);
            em.persist(student3);


            em.getTransaction().commit();

            System.out.println("All data persisted... ");
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }
}
