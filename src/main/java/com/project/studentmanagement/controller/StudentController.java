package com.project.studentmanagement.controller;

import com.project.studentmanagement.entity.Student;
import com.project.studentmanagement.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{studentId}")
    public String editStudentForm(@PathVariable Long studentId, Model model){
        Student student = (Student) studentService.getStudent(studentId);
        System.out.println("\n\n\n*****" + studentService.getStudent(studentId) + "*****\n\n\n");
        model.addAttribute("student",student);
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable Long studentId,
                                @ModelAttribute("student") Student student,
                                Model model){

        Student existingStudent = (Student) studentService.getStudent(studentId);
        existingStudent.setStudentId(student.getStudentId());
        existingStudent.setName(student.getName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

}
