package Banking_Management_System;

enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER_IN,
    TRANSFER_OUT
}

class Transaction {
    private int transactionId;
    private long accountNumber;
    private TransactionType type;
    private double amount;
    private String date;

    public Transaction(int transactionId, long accountNumber,
                       TransactionType type, double amount, String date) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Type           : " + type);
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Date           : " + date);
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
