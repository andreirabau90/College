package com.company.Controller;

import com.company.Dao.DaoBD;
import com.company.Dao.DaoCollege;
import com.company.Entity.Group;
import com.company.Entity.Student;

public class Controller {
    public DaoCollege myStudet = new DaoBD();

    public void addStudent(Student student) {
        myStudet.addStudent(student);
    }

    public void allStudent() {
        myStudet.allStudent();
    }

    public void updateStudent(int a, String b, int c, int d) {
        myStudet.updateStudent(a, b, c, d);
    }

    public void deleteStudent(int a) {
        myStudet.deleteStudent(a);
    }

    public void searchStudent(String name) {
        myStudet.searchStudent(name);
    }

    public void allGroup() {
        myStudet.allGroup();
    }

    public void addGroup(Group group) {
        myStudet.addGroup(group);
    }

    public void editGroup(int a, String b) {
        myStudet.editGroup(a, b);
    }

    public void deleteGroup(int a) {
        myStudet.deleteGroup(a);
    }

    public void getStudentsFromGroup(int group_id) {
        myStudet.StudentInGroup(group_id);
    }

    public void Document() {myStudet.Document();
    }
}
