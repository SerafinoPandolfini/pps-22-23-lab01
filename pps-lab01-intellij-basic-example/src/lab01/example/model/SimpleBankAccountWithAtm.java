package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final AccountHolder holder;

    private double balance;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder, double initialBalance) {
        holder = accountHolder;
        balance = initialBalance;

    }

    @Override
    public AccountHolder getHolder() {
        return holder;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (checkUser(userID)) {
            balance = balance + amount - 1;
        }
    }

    private boolean checkUser(int userID) {
        return userID == holder.getId();
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID)) {
            balance = balance - amount - 1;
        }
    }
}
