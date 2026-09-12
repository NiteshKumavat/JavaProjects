package Student_management_System;

import java.util.Scanner;

public class Student {

    studentInfo studentHead = null;

    void insert_data(studentInfo info){
        if(studentHead == null){
            studentHead = info;
            info.next = null;
        }
        else{
            studentInfo temp = studentHead;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = info;
            info.next = null;
        }
    }

    void display(){
        if(studentHead == null){
            System.out.println("Records are empty.");
        }
        else{
            studentInfo temp = studentHead;
            System.out.println("------------------------------------------------");
            System.out.println("Student details");
            System.out.println("------------------------------------------------");
            int count = 1;

            while(temp != null){
                System.out.println("Record : " + count++);
                System.out.println("Student name : " + temp.name + "\nAge : " + temp.age + "\nCourse : " + temp.course);
                System.out.println("------------------------------------------------");
                temp = temp.next;
            }
        }
    }

    static class studentInfo{
        String name, course;
        int age;
        studentInfo next;

        studentInfo(String name, String course, int age){
            this.age = age;
            this.name = name;
            this.course = course;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student system = new Student();

        while (true){
            System.out.println("\nOptions: 1 for Add | 2 for Display | 3 for Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter the name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter the course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter the age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    studentInfo s = new studentInfo(name, course, age);

                    // FIX: Insert data into the instance
                    system.insert_data(s);
                    System.out.println("Student record added successfully!");
                    break;

                case 2:
                    system.display();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        }
    }
}