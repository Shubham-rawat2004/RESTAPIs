package com.RestAPI.RESTAPIs.Repository;

import com.RestAPI.RESTAPIs.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name); // custom query when no built -in .Spring automatically generates query using convention


    List<Student> findByNameAndCity(String name, String city);


}
