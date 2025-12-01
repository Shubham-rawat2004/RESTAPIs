package com.RestAPI.RESTAPIs.Controller;

import com.RestAPI.RESTAPIs.Model.Student;

import java.util.List;

import com.RestAPI.RESTAPIs.Service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get student by ID
    @GetMapping("/id/{id}")
    Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    // Get student by name
    @GetMapping("/name/{name}")
    List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getByName(name);
    }

    // Get student by name and city
    @GetMapping("/name/{name}/city/{city}")
    List<Student> getByNameAndCity(@PathVariable String name, @PathVariable String city) {
        return studentService.getByNameAndCity(name, city);
    }

    // Get all students
    @GetMapping("/all")
    List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Add new student
    @PostMapping("/student")
    Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // Update student
    @PutMapping("/update/{id}")
    Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    // Delete student
    @DeleteMapping("/id/{id}")
    void deleteByID(@PathVariable long id) {
        studentService.deleteById(id);
    }
}
