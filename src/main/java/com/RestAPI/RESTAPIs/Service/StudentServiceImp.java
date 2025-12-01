package com.RestAPI.RESTAPIs.Service;

import com.RestAPI.RESTAPIs.Model.Student;
import com.RestAPI.RESTAPIs.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByName(String name) {
        List<Student> students = studentRepository.findByName(name);

        if (students.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No student found with name " + name
            );
        }
        return students;
    }

    @Override
    public List<Student> getByNameAndCity(String name, String city) {
        List<Student> students = studentRepository.findByNameAndCity(name, city);

        if (students.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Student with name " + name + " and city " + city + " does not exist"
            );
        }
        return students;
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student not found"
                        ));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentById(long id, Student student) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student does not exist"
                        ));

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setEmail(student.getEmail());

        return studentRepository.save(existing);  // also fixed missing save
    }

    @Override
    public void deleteById(long id) {
        studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Student with id " + id + " does not exist"
                        ));

        studentRepository.deleteById(id);
    }
}
