package Sep_24_2025_1;

public class CurrentAccount extends BankAccount{

    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public boolean deposit(double money) {
        if (money > 0) {
            this.setBalance(this.getBalance() + money);
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double money) {
        if  (money <= this.getBalance()) {
            this.setBalance(this.getBalance() - money);
            return true;
        }
        return false;
    }
}
