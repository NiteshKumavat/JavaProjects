package Student_management_System;

import java.util.Scanner;

public class Student {

    studentInfo studentHead = null;
    int nextSid = 1;

    void insert_data(studentInfo info) {
        info.sid = nextSid++;
        info.next = null;

        if (studentHead == null) {
            studentHead = info;
            return;
        }

        studentInfo temp = studentHead;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = info;
    }

    void display() {
        if (studentHead == null) {
            System.out.println("Records are empty.");
            return;
        }
        studentInfo temp = studentHead;

        System.out.println("------------------------------------------------");
        System.out.println("              Student Details");
        System.out.println("------------------------------------------------");

        while (temp != null) {
            System.out.println("Student ID   : " + temp.sid);
            System.out.println("Student Name : " + temp.name);
            System.out.println("Age          : " + temp.age);
            System.out.println("Course       : " + temp.course);

            System.out.println("------------------------------------------------");
            temp = temp.next;
        }
    }

    void deleteData(int sid) {

        if (studentHead == null) {
            System.out.println("List is empty!");
            return;
        }

        if (studentHead.sid == sid) {
            studentHead = studentHead.next;
            System.out.println("Data deleted successfully.");
            return;
        }

        studentInfo temp = studentHead;

        while (temp.next != null) {
            if (temp.next.sid == sid) {
                temp.next = temp.next.next;
                System.out.println("Data deleted successfully.");
                return;
            }

            temp = temp.next;
        }
        System.out.println("Student ID not found.");
    }

    static class studentInfo {

        String name;
        String course;
        int age;
        int sid;
        studentInfo next;

        studentInfo(String name, String course, int age) {
            this.name = name;
            this.course = course;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student system = new Student();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter the course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter the age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    studentInfo s = new studentInfo(name, course, age);

                    system.insert_data(s);
                    System.out.println("Student record added successfully!");
                    System.out.println("Student ID: " + s.sid);
                    break;

                case 2:
                    system.display();
                    break;

                case 3:
                    System.out.print("Enter the student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    system.deleteData(id);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select 1, 2, 3, or 4.");
            }
        }
    }
}