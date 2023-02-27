package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private static final int ATM_FEE = 1;
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
            balance = balance + amount - ATM_FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            balance = balance - amount - ATM_FEE;
        }
    }

    private boolean checkUser(int userID) {
        return userID == holder.getId();
    }

    private boolean isWithdrawAllowed(double amount) {
        return balance - ATM_FEE >= amount;
    }
}
