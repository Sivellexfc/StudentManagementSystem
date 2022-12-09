package com.project.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "seq",initialValue = 1000,allocationSize = 3)
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @Column(name = "student_ıd", nullable = false)
    private Long studentId;

    @Column(name = "studentName")
    private String name;
    @Column(name = "StudentLastName")
    private String lastName;
    @Column(name = "studentEmail")
    private String email;

    public Student() {
    }

    public Student(Long studentId, String name, String lastName, String email) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
