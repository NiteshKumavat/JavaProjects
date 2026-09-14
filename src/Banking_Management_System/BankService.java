package Banking_Management_System;

import java.util.ArrayList;
import java.util.List;

class BankService {

    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        account.deposit(amount);

        Transaction transaction = new Transaction(
                transactions.size() + 1,
                account.getAccountNumber(),
                TransactionType.DEPOSIT,
                amount,
                "14-09-2026"
        );

        transactions.add(transaction);

        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (account.withdraw(amount)) {

            Transaction transaction = new Transaction(
                    transactions.size() + 1,
                    account.getAccountNumber(),
                    TransactionType.WITHDRAW,
                    amount,
                    "14-09-2026"
            );

            transactions.add(transaction);

            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    public void transfer(Account from, Account to, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (from.withdraw(amount)) {

            to.deposit(amount);

            Transaction transaction1 = new Transaction(
                    transactions.size() + 1,
                    from.getAccountNumber(),
                    TransactionType.TRANSFER_OUT,
                    amount,
                    "14-09-2026"
            );

            transactions.add(transaction1);

            Transaction transaction2 = new Transaction(
                    transactions.size() + 1,
                    to.getAccountNumber(),
                    TransactionType.TRANSFER_IN,
                    amount,
                    "14-09-2026"
            );

            transactions.add(transaction2);

            System.out.println("Transfer successful.");
        }
    }

    public void printTransactionHistory(Account account) {

        System.out.println("Transaction History");
        System.out.println("--------------------");

        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber() ==
                    account.getAccountNumber()) {

                transaction.displayTransaction();
                System.out.println();
            }
        }
    }
}