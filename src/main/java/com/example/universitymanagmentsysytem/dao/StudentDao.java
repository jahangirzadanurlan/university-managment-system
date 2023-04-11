package com.example.universitymanagmentsysytem.dao;

import com.example.universitymanagmentsysytem.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> showStudents();
    Student showStudentById(Long id);
    boolean register(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Long id);
}
