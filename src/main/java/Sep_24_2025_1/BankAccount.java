package Sep_24_2025_1;

public abstract class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract boolean deposit(double money);

    public abstract boolean withdraw(double money);
}
