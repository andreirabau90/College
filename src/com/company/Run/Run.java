package com.company.Run;

import com.company.Controller.Controller;
import com.company.Entity.Group;
import com.company.Entity.Student;

import java.util.Scanner;

public class Run {
    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();

    private void ShowMenu() {
        System.out.println("Выберете действие ");
        System.out.println("1- добавить студента");
        System.out.println("2- вывод всех студентов");
        System.out.println("3- редактировать студента");
        System.out.println("4- удалить студента");
        System.out.println("5- поиск студента по имени");
        System.out.println("6- вывод всех групп");
        System.out.println("7-добавление группы");
        System.out.println("8-редактирование группы");
        System.out.println("9- удаление группы");
        System.out.println("10- вывод всех студентов группы");
        System.out.println("11- отчет");
        System.out.println("0- выход");
    }

    public void run() {
        while (true) {

            ShowMenu();
            int index = 0;
            index = sc.nextInt();
            if (index < 0 && index > 12) {
                break;
            } else if (index == 0) {
                System.out.println("выход");
                break;
            }
            switch (index) {
                case 1:

                    addStudent();
                    break;
                case 2:
                    allStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    printAllGroups();
                    break;
                case 7:
                    addGroup();
                    break;
                case 8:
                    editGroup();
                    break;
                case 9:
                    deleteGroup();
                    break;
                case 10:
                    StudentInGroup();
                    break;
                case 11:
                    Document();
                    break;

            }

        }

    }

    public void addStudent() {
        try {
            System.out.println("name");
            String name = sc.next();
            System.out.println("age");
            int age = sc.nextInt();
            System.out.println("groups:");
            printAllGroups();
            Group group = new Group();
            group.setIdGroup(sc.nextInt());
            controller.addStudent(new Student(name, age, group));
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();
        }



    }

    private void allStudent() {
        System.out.println("все студенты");
        controller.allStudent();
    }

    void editStudent() {
        try {
            System.out.println("Edit student");
            allStudent();
            System.out.println("введите ID студента");
            int id = sc.nextInt();
            System.out.println("введите  имя ");
            String name = sc.next();
            System.out.println("введите возраст");
            int age = sc.nextInt();
            System.out.println("введите группу");
            printAllGroups();
            int group_id = sc.nextInt();
            controller.updateStudent(id, name, age, group_id);
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();
        }
    }
        void deleteStudent () {
        try {
            System.out.println("введите ID студента на отчисление");
            allStudent();
            int a = sc.nextInt();
            controller.deleteStudent(a);
        }catch (Exception e){
            System.out.println("Вы ввели некорректное значение");
            sc.next();
        }

        }

        void searchStudent() {
            try {
                System.out.println("введите имя студента");
                String name = sc.next();
                controller.searchStudent(name);
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение");
                sc.next();

            }
        }
        void printAllGroups () {
            System.out.println("все группы");
            controller.allGroup();
        }

        void addGroup () {
        try {
            System.out.println("введите название группы");
            String nameGroup = sc.next();
            controller.addGroup(new Group(nameGroup));
        }catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();

        }

        }

        void editGroup() {
        try {
            printAllGroups();
            System.out.println("введите ID группы");
            int a = sc.nextInt();
            System.out.println("введите  имя ");
            String b = sc.next();
            controller.editGroup(a, b);
        }catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();

        }

        }

        void deleteGroup () {
        try{
            System.out.println("введите ID группы на удаление");
            printAllGroups();
            int a = sc.nextInt();
            controller.deleteGroup(a);
        }catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();

        }

        }

        void StudentInGroup () {
        try{
            System.out.println("введите ID группы");
            printAllGroups();
            int group_id = sc.nextInt();
            controller.getStudentsFromGroup(group_id);
        }catch (Exception e) {
            System.out.println("Вы ввели некорректное значение");
            sc.next();

        }


        }

        void Document () {
        controller.Document();
        }
    }


