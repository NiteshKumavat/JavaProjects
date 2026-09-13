package Library_Management_System;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        library.addBook(new Book("Clean Code", "Robert Martin", "B101", "Tech", 5, 45.00f));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "B102", "Fiction", 3, 20.00f));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("\tAllinOne Library");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. View all books");
            System.out.println("2. Buy a book");
            System.out.println("3. Rent a book for a week");
            System.out.println("4. Return a book");
            System.out.println("5. Check your bill");
            System.out.println("6. Add a book (Only admin)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID to buy: ");
                    String buyId = scanner.nextLine();
                    library.buyBook(buyId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to rent: ");
                    String rentId = scanner.nextLine();
                    library.rentBook(rentId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = scanner.nextLine();
                    library.returnBook(returnId);
                    break;

                case 5:
                    library.showBill();
                    break;

                case 6:
                    System.out.print("Enter Admin Password: ");
                    String pass = scanner.nextLine();
                    if (!pass.equals("admin123")) {
                        System.out.println("Access Denied: Incorrect Password!");
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter Sale Price: ");
                    float price = scanner.nextFloat();

                    library.addBook(new Book(title, author, id, category, stock, price));
                    break;

                case 7:
                    System.out.println("Thank you for using AllinOne Library. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }
}