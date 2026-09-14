package Banking_Management_System;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;

        do {
            System.out.println("\n========== BANK MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Check Balance");
            System.out.println("7. Display Account Details");
            System.out.println("8. Display All Customers");
            System.out.println("9. Display All Accounts");
            System.out.println("10. Transaction History");
            System.out.println("11. Close Account");
            System.out.println("0. Exit");
            System.out.println("============================================");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    String customerId = sc.nextLine();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Customer customer = new Customer(customerId, name, email, phone);
                    bank.addCustomer(customer);
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int custId = sc.nextInt();

                    System.out.println("Select Account Type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Enter choice: ");
                    int accTypeChoice = sc.nextInt();

                    System.out.print("Enter Initial Deposit Amount: ");
                    double initialDeposit = sc.nextDouble();

                    if (accTypeChoice == 1) {
                        System.out.print("Enter Interest Rate (%): ");
                        double interestRate = sc.nextDouble();
                        bank.createSavingsAccount(custId, initialDeposit, interestRate);
                    } else if (accTypeChoice == 2) {
                        System.out.print("Enter Overdraft Limit: ");
                        double overdraftLimit = sc.nextDouble();
                        bank.createCurrentAccount(custId, initialDeposit, overdraftLimit);
                    } else {
                        System.out.println("Invalid Account Type.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    long depAccNum = sc.nextLong();

                    System.out.print("Enter Amount to Deposit: ");
                    double depAmount = sc.nextDouble();

                    bank.deposit(depAccNum, depAmount);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    long withAccNum = sc.nextLong();

                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmount = sc.nextDouble();

                    bank.withdraw(withAccNum, withAmount);
                    break;

                case 5:
                    System.out.print("Enter Source Account Number: ");
                    long srcAcc = sc.nextLong();

                    System.out.print("Enter Destination Account Number: ");
                    long destAcc = sc.nextLong();

                    System.out.print("Enter Transfer Amount: ");
                    double transferAmount = sc.nextDouble();

                    bank.transfer(srcAcc, destAcc, transferAmount);
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    long checkAccNum = sc.nextLong();

                    bank.checkBalance(checkAccNum);
                    break;

                case 7:
                    System.out.print("Enter Account Number: ");
                    long detailAccNum = sc.nextLong();

                    bank.displayAccountDetails(detailAccNum);
                    break;

                case 8:
                    bank.displayAllCustomers();
                    break;

                case 9:
                    bank.displayAllAccounts();
                    break;

                case 10:
                    System.out.print("Enter Account Number: ");
                    long historyAccNum = sc.nextLong();

                    bank.displayTransactionHistory(historyAccNum);
                    break;

                case 11:
                    System.out.print("Enter Account Number to Close: ");
                    long closeAccNum = sc.nextLong();

                    bank.closeAccount(closeAccNum);
                    break;

                case 0:
                    System.out.println("Thank you for using the Bank Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 0 to 11.");
            }

        } while (choice != 0);

        sc.close();
    }
}