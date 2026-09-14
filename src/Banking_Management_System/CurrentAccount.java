package Banking_Management_System;

class CurrentAccount extends Account {

    private double overdraftLimit;

    CurrentAccount(long accountNumber, Customer customer, double balance, double overdraftLimit) {
        super(accountNumber, customer, balance);
        this.overdraftLimit = overdraftLimit;
    }


    @Override
    public void withdraw(double amount){
        if(amount > 0 && (getBalance() - amount) >= -overdraftLimit){
            setBalance(getBalance() - amount);
        }else{
            System.out.println("Withdraw failed : Overdraft limit exceeded.");
        }
    }

    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}