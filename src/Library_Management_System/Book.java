package Library_Management_System;

public class Book {
    private String name, authorName, bsnId, category;
    private int stockQuantity;
    private float price, rentalPrice;

    public Book(String name, String authorName, String bsnId, String category, int quantity, float price) {
        this.name = name;
        this.authorName = authorName;
        this.bsnId = bsnId;
        this.category = category;
        this.stockQuantity = quantity;
        this.price = price;
        this.rentalPrice = price / 20; // Default: 5% of purchase price
    }

    // --- GETTERS ---
    public String getName() { return this.name; }
    public String getAuthorName() { return this.authorName; }
    public String getBSNID() { return this.bsnId; }
    public String getCategory() { return this.category; }
    public int getStockQuantity() { return this.stockQuantity; }
    public float getPrice() { return this.price; }
    public float getRentalPrice() { return this.rentalPrice; }

    // --- SETTERS & VALIDATIONS ---
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name!");
        } else {
            this.name = name;
            System.out.println("Book name updated successfully.");
        }
    }

    public boolean setRentalPrice(float newRentalPrice) {
        float maxAllowedRental = price / 10;
        if (newRentalPrice > maxAllowedRental) {
            System.out.println("Error: Rental price cannot exceed 10% of sale price (Max: " + maxAllowedRental + ")");
            return false;
        }
        this.rentalPrice = newRentalPrice;
        return true;
    }

    // --- BUSINESS LOGIC METHODS ---
    public boolean buyCopy() {
        if (stockQuantity > 0) {
            stockQuantity--;
            return true;
        }
        return false;
    }

    public boolean rentCopy() {
        if (stockQuantity > 0) {
            stockQuantity--;
            return true;
        }
        return false;
    }

    public void returnCopy() {
        stockQuantity++;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            this.stockQuantity += quantity;
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Title: %-20s | Author: %-15s | Category: %-10s | Stock: %-3d | Price: $%.2f | Rent: $%.2f/wk",
                bsnId, name, authorName, category, stockQuantity, price, rentalPrice);
    }
}