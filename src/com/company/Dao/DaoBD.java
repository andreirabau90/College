package com.company.Dao;

import com.company.Entity.Group;
import com.company.Entity.Student;
import com.company.conect.MysqlConnection;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoBD implements DaoCollege {


    @Override
    public void addStudent(Student student) {
        try {
            Connection connection = MysqlConnection.getConnection();
            String sql = "INSERT INTO college.students VALUES (null ,?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getNameStudent());
            statement.setInt(2, student.getAgeStudent());
            statement.setInt(3, student.group.getIdGroup());
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void allStudent() {

        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT students.*, college.groups.name_group FROM students LEFT JOIN college.groups ON college.groups.id = students.group_id order by students.id");
            while (resultSet.next()) {
                tableStudents(resultSet);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(int id, String name, int age, int group_id) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update students " +
                    " set name=?, age=?, group_id=? " +
                    " where id=?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, group_id);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(int idStudent) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete  From students where id=?");
            preparedStatement.setInt(1, idStudent);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(String name) {
        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT students.*, college.groups.name_group  FROM students LEFT JOIN college.groups ON college.groups.id = students.group_id order by students.id");
            while (resultSet.next()) {
                String nameStudent = resultSet.getString(2).toLowerCase();
                String SearchName = name.toLowerCase();
                if (nameStudent.startsWith(SearchName)) {
                    tableStudents(resultSet);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void allGroup() {
        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM college.`groups`");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name_group");
                System.out.println(id + " " + " name   " + name);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addGroup(Group group) {
        try {
            Connection connection = MysqlConnection.getConnection();
            String sql = "INSERT INTO college.groups VALUES (null ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, group.getNumGroup());
            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editGroup(int idGroup, String numGroup) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update college.groups set  name_group=?where id=?;");
            preparedStatement.setString(1, numGroup);
            preparedStatement.setInt(2, idGroup);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteGroup(int idgroup) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete  From college.groups where id=?");
            preparedStatement.setInt(1, idgroup);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void StudentInGroup(int groupId) {
        try {
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE group_id=?");
            preparedStatement.setInt(1, groupId);

            ResultSet resultSet = preparedStatement.executeQuery("SELECT students.*, college.groups.name_group  FROM students LEFT JOIN college.groups ON college.groups.id = students.group_id order by students.id");
            while (resultSet.next()) {
                if (resultSet.getInt(4) == groupId) {
                    tableStudents(resultSet);
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Document() {
        File file = new File("college.txt");
        file.delete();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList <Integer> idGroup = new ArrayList <>();
        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select college.groups.id from college.groups");
            while (resultSet.next()) {
                resultSet.getInt(1);
                idGroup.add(resultSet.getInt(1));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("не работает");
            e.printStackTrace();
        }
        try {
            Connection connection = MysqlConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select college.groups.name_group,students.* from college.groups left  join students on college.groups.id = students.group_id");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));

            for (int i = 0; i < idGroup.size(); i++) {
                resultSet.beforeFirst();
                bufferedWriter.newLine();
                while (resultSet.next()) {
                    if (idGroup.get(i) == resultSet.getInt(5)) {
                        bufferedWriter.write("group name  " + resultSet.getString(1));
                        resultSet.beforeFirst();
                        bufferedWriter.newLine();
                        while (resultSet.next()) {
                            if (idGroup.get(i) == resultSet.getInt(5)) {
                                bufferedWriter.write(" id =  " + resultSet.getInt(2) + " name =  " + resultSet.getString(3) + " age =  " + resultSet.getInt(4) + "\n");
                            }
                        }
                    }
                }
            }
            resultSet.close();
            bufferedWriter.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("не хочет работать");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void tableStudents(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String name_group = resultSet.getString("name_group");
            System.out.println("id  " + id + " " + " name   " + name + " age " + age + " group  " + name_group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
