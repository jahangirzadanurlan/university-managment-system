package com.example.universitymanagmentsysytem.service.impl;

import com.example.universitymanagmentsysytem.dao.StudentDao;
import com.example.universitymanagmentsysytem.model.Student;
import com.example.universitymanagmentsysytem.service.StudentService;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Override
    public List<Student> showStudents() {
        return studentDao.showStudents();
    }

    @Override
    public Student showStudentById(Long id) {
        return studentDao.showStudentById(id);
    }

    @Override
    public void registerStudent(Student student) {
        studentDao.register(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }
}
