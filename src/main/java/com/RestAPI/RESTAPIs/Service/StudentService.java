package com.RestAPI.RESTAPIs.Service;

import com.RestAPI.RESTAPIs.Model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    List<Student> getByName(String name);

    List<Student> getByNameAndCity(String name, String city);

    Student getStudentById(long id);


    Student save(Student student);

    Student updateStudentById(long id, Student student);

    void deleteById(long id);
}
