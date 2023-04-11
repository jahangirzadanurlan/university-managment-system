package com.example.universitymanagmentsysytem.controller;

import com.example.universitymanagmentsysytem.model.Student;
import com.example.universitymanagmentsysytem.service.impl.StudentServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@WebServlet("/list")
public class StudentController extends HttpServlet {
    private final StudentServiceImpl service;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String path=req.getServletPath();
        switch (path){
            case "new":
                showNewForm(req,resp);
                break;
            case "list":
                listPage(req,resp);
                break;
            case "delete":
                deleteStudent(req,resp);
                break;
            case "update":
                updateStudent(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "insert":
                insertStudent(req,resp);
                break;
            default:
                listStudent(req,resp);
                break;


        }

        List<Student> studentList=service.showStudents();
        req.setAttribute("studentList",studentList);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("student-list.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
    public void showNewForm(HttpServletRequest req,HttpServletResponse resp){
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("student-form.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void listPage(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> studentList=service.showStudents();
        req.setAttribute("studentList",studentList);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("student-list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id=Long.parseLong(req.getParameter("id"));
        service.deleteStudent(id);

        resp.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id=Long.parseLong(req.getParameter("id"));

        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        int age=Integer.parseInt(req.getParameter("age"));

        Student student=Student.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build();
        service.updateStudent(student);
        resp.sendRedirect("list");

    }
    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        int age=Integer.parseInt(req.getParameter("age"));

        Student student=Student.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build();
        service.updateStudent(student);
        resp.sendRedirect("list");
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student selectedStudent= service.showStudentById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", selectedStudent);
        dispatcher.forward(request, response);
    }
    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students=service.showStudents();
        req.setAttribute("listStudent",students);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("student-list.jsp");
        requestDispatcher.forward(req,resp);
    }


}
