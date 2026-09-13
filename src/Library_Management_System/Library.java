package Library_Management_System;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private float totalBill;

    public Library() {
        this.books = new ArrayList<>();
        this.totalBill = 0.0f;
    }

    // Admin: Add a new book to the catalog
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getName() + "' added to library inventory.");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books currently available in the catalog.");
            return;
        }
        System.out.println("\n---------------------------------- AVAILABLE BOOKS ----------------------------------");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public Book findBookById(String bsnId) {
        for (Book book : books) {
            if (book.getBSNID().equalsIgnoreCase(bsnId)) {
                return book;
            }
        }
        return null;
    }

    public void buyBook(String bsnId) {
        Book book = findBookById(bsnId);
        if (book == null) {
            System.out.println("Error: Book with ID " + bsnId + " not found.");
            return;
        }

        if (book.buyCopy()) {
            totalBill += book.getPrice();
            System.out.println("Successfully purchased '" + book.getName() + "' for $" + book.getPrice());
        } else {
            System.out.println("Sorry, '" + book.getName() + "' is currently out of stock.");
        }
    }

    public void rentBook(String bsnId) {
        Book book = findBookById(bsnId);
        if (book == null) {
            System.out.println("Error: Book with ID " + bsnId + " not found.");
            return;
        }

        if (book.rentCopy()) {
            totalBill += book.getRentalPrice();
            System.out.println("Successfully rented '" + book.getName() + "' for 1 week at $" + book.getRentalPrice());
        } else {
            System.out.println("Sorry, '" + book.getName() + "' is out of stock for rental.");
        }
    }

    public void returnBook(String bsnId) {
        Book book = findBookById(bsnId);
        if (book == null) {
            System.out.println("Error: Book with ID " + bsnId + " does not belong to this library system.");
            return;
        }

        book.returnCopy();
        System.out.println("Thank you! '" + book.getName() + "' has been returned and added back to stock.");
    }

    public void showBill() {
        System.out.println("\n=================================");
        System.out.printf("  Current Outstanding Bill: $%.2f\n", totalBill);
        System.out.println("=================================");
    }
}