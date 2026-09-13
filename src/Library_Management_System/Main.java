package Library_Management_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String name, mobileNo;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your correct mobile number : ");
            mobileNo = sc.nextLine();
        }while(mobileNo.length() != 10 && mobileNo.matches("//d+"));

        while(true){
            System.out.println("-----------------------------------------------------------");
            System.out.println("\t\tAllinOne Library");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. View All Books");
            System.out.println("2. Search Book (by Title / Author / Genre)");
            System.out.println("3. Borrow / Rent a Book");
            System.out.println("4. Buy a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. View My Cart & Bill");
            System.out.println("7. Admin Panel (Add / Remove Books)");
            System.out.println("8. Exit");
            System.out.println("-----------------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1 : break;
                case 2 : break;
                case 3 : break;
                case 4 : break;
                case 5 : break;
                case 6 : break;
                case 7 : break;
                case 8 :
                    break;
                default :
                    System.out.println("Enter the valid options in between 1 to 8");

            }
        }

    }
}
