package com.example.universitymanagmentsysytem.query;

public class StudentQuery {
    public static final String SHOW_STUDENTS="SELECT * FROM student WHERE status=1";
    public static final String SHOW_STUDENT_BY_ID="SELECT * FROM student WHERE id=? ans status=1";
    public static final String REGISTER="INSERT INTO student(name,surname,age) VALUES(?,?,?)";
    public static final String UPDATE_STUDENT="UPDATE student SET name=?,surname=?,age=? WHERE id=? and status=1";
    public static final String DELETE_STUDENT="UPDATE student SET status=0 WHERE id=? and status=1";

}
