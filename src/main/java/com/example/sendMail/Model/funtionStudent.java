package com.example.sendMail.Model;

import java.sql.*;

import java.util.ArrayList;



public class funtionStudent {
    ArrayList<student> students = new ArrayList<>();

    public ArrayList<student> getAll(){
       try {
            students.clear();
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement stsm = con.createStatement();
            ResultSet rs = stsm.executeQuery("select * from student.student");
            while (rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("name");
               student student = new student(id, name);
               students.add(student);
            }
            con.close();
            return students;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        funtionStudent f = new funtionStudent();
        System.out.println(f.getAll().toString());
    }
}
