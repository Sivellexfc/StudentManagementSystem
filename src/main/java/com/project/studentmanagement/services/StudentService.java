package com.project.studentmanagement.services;

import com.project.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student saveStudent(Student student);
    Student getStudent(Long id);
    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
