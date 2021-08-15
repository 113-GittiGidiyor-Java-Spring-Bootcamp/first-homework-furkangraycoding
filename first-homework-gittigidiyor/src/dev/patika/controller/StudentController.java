package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();
    public Student findStudent(int studentId){
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){

        studentService.saveToDatabase(student);

    }

    public void deleteStudent(int id){
        studentService.deleteFromDatabase(id);

    }

    public List<Course> findCourseOfStudent(int id){
        return null;

    }

    public void updateStudent(Student student,int id){
        studentService.updateOnDatabase(student,id);

    }


}
