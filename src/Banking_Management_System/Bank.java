package Banking_Management_System;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;

    private long nextAccountNumber = 1001;
    private int nextTransactionId = 1;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    private String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }


    private void recordTransaction(long accountNumber, TransactionType type, double amount) {
        Transaction tx = new Transaction(nextTransactionId++, accountNumber, type, amount, getCurrentDateTime());
        transactions.add(tx);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public void createSavingsAccount(int customerId, double initialBalance, double interestRate) {
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Please add the customer first.");
            return;
        }

        long accountNumber = nextAccountNumber++;
        SavingsAccount sa = new SavingsAccount(accountNumber, customer, initialBalance, interestRate);
        accounts.add(sa);

        System.out.println("Savings Account created successfully with Account Number: " + accountNumber);
        if (initialBalance > 0) {
            recordTransaction(accountNumber, TransactionType.DEPOSIT, initialBalance);
        }
    }

    public void createCurrentAccount(int customerId, double initialBalance, double overdraftLimit) {
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Please add the customer first.");
            return;
        }

        long accountNumber = nextAccountNumber++;
        CurrentAccount ca = new CurrentAccount(accountNumber, customer, initialBalance, overdraftLimit);
        accounts.add(ca);

        System.out.println("Current Account created successfully with Account Number: " + accountNumber);
        if (initialBalance > 0) {
            recordTransaction(accountNumber, TransactionType.DEPOSIT, initialBalance);
        }
    }

    public Account findAccount(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void closeAccount(long accountNumber) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(account);
        System.out.println("Account " + accountNumber + " closed successfully.");
    }

    // --- BANK TRANSACTIONS ---

    public void deposit(long accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.deposit(amount);
        recordTransaction(accountNumber, TransactionType.DEPOSIT, amount);
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double initialBalance = account.getBalance();
        account.withdraw(amount);

        // Record transaction only if balance changed (successful withdrawal)
        if (account.getBalance() < initialBalance) {
            recordTransaction(accountNumber, TransactionType.WITHDRAW, amount);
        }
    }

    public void transfer(long sourceAccNum, long destAccNum, double amount) {
        if (sourceAccNum == destAccNum) {
            System.out.println("Source and destination account numbers cannot be the same.");
            return;
        }

        Account sourceAcc = findAccount(sourceAccNum);
        Account destAcc = findAccount(destAccNum);

        if (sourceAcc == null) {
            System.out.println("Source account not found.");
            return;
        }
        if (destAcc == null) {
            System.out.println("Destination account not found.");
            return;
        }

        double initialBalance = sourceAcc.getBalance();
        sourceAcc.withdraw(amount);

        if (sourceAcc.getBalance() < initialBalance) {
            destAcc.deposit(amount);
            recordTransaction(sourceAccNum, TransactionType.TRANSFER_OUT, amount);
            recordTransaction(destAccNum, TransactionType.TRANSFER_IN, amount);
            System.out.println("Transfer of ₹" + amount + " completed successfully.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void checkBalance(long accountNumber) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.println("Current Balance for Account " + accountNumber + ": ₹" + account.getBalance());
    }

    // --- DISPLAY & REPORTING ---

    public void displayAccountDetails(long accountNumber) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.displayAccount();
        System.out.println("Account Holder : " + account.customer.getName());
    }

    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            customer.displayCustomer();
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    public void displayTransactionHistory(long accountNumber) {
        Account account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        boolean found = false;
        System.out.println("\n--- Transaction History for Account: " + accountNumber + " ---");
        for (Transaction tx : transactions) {
            if (tx.getAccountNumber() == accountNumber) {
                tx.displayTransaction();
                System.out.println("-------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for this account.");
        }
    }
}