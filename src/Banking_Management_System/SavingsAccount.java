package Banking_Management_System;

public class SavingsAccount extends Account{
    private double interestRate;


    public SavingsAccount(long accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, customer, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void addInterest() {
        balance += calculateInterest();
    }

}
