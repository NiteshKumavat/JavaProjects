package Banking_Management_System;

public class Account {
    protected long accountNumber;
    protected Customer customer;
    protected double balance;

    Account(long accountNumber, Customer customer, double balance){
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Invalid amount.");
            return;
        }
        this.balance += amount;
        System.out.println("Amount added successfully");
    }

    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("Amount can't be in negative");
            return;
        }
        if(amount > this.balance){
            System.out.println("Insufficent Balance");
            return;
        }
        this.balance -= amount;
        System.out.println("You withdraw the amount of " + amount + " rupees");
    }

    public void displayAccount(){
        System.out.println("-------------------------------------------------------");
        System.out.println("         Account details");
        System.out.println("-------------------------------------------------------");
        System.out.println("Your account number is " + this.accountNumber);
        System.out.println("Your total balance is " + this.balance + " rupees");
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
