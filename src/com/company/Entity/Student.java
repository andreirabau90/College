package com.company.Entity;

public class Student {
    private int idStudent;
    private String nameStudent;
    private int ageStudent;
    public Group group;


    public Student(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", nameStudent='" + nameStudent + '\'' +
                ", ageStudent=" + ageStudent +
                ", group=" + group +
                '}';
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public Group getGroup() {
        return group;
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    public Student() {

    }

    public Student(String nameStudent, int ageStudent, Group group) {

        this.nameStudent = nameStudent;
        this.ageStudent = ageStudent;
        this.group = group;

    }
}
