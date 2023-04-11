package com.example.universitymanagmentsysytem.service;

import com.example.universitymanagmentsysytem.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> showStudents();
    Student showStudentById(Long id);
    void registerStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
