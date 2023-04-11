package com.example.universitymanagmentsysytem.dao.impl;

import com.example.universitymanagmentsysytem.config.DatabaseConfig;
import com.example.universitymanagmentsysytem.dao.StudentDao;
import com.example.universitymanagmentsysytem.model.Student;
import com.example.universitymanagmentsysytem.query.StudentQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImpl extends DatabaseConfig implements StudentDao {
    @Override
    public List<Student> showStudents() {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(StudentQuery.SHOW_STUDENTS);
            List<Student> students=new LinkedList<>();

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id =resultSet.getLong("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                int age=resultSet.getInt("age");

                Student student=Student.builder()
                        .id(id)
                        .name(name)
                        .surname(surname)
                        .age(age)
                        .build();

                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return null;
    }

    @Override
    public Student showStudentById(Long id) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(StudentQuery.SHOW_STUDENT_BY_ID);
            preparedStatement.setLong(1,id);
            List<Student> students=new LinkedList<>();

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Long idi =resultSet.getLong("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                int age=resultSet.getInt("age");

                Student student=Student.builder()
                        .id(idi)
                        .name(name)
                        .surname(surname)
                        .age(age)
                        .build();

                students.add(student);
            }
            return students.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(Student student) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(StudentQuery.REGISTER);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setInt(3,student.getAge());

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        try(Connection connection=connect()){
            PreparedStatement preparedStatement=connection.prepareStatement(StudentQuery.UPDATE_STUDENT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,student.getId());

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Long id) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(StudentQuery.DELETE_STUDENT);
            preparedStatement.setLong(1,id);

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
