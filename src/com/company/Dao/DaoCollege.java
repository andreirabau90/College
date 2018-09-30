package com.company.Dao;

import com.company.Entity.Group;
import com.company.Entity.Student;

public interface DaoCollege {
    void addStudent(Student student);

    void allStudent();

    void updateStudent(int a, String b, int c, int d);

    void deleteStudent(int a);

    void searchStudent(String name);

    void allGroup();

    void addGroup(Group group);

    void editGroup(int a, String b);

    void deleteGroup(int a);

    void StudentInGroup(int a);

    void Document();
}
