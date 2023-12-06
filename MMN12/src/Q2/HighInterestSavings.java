package Q2;

public class HighInterestSavings extends SavingsAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.05; // 5% annual interest rate
    private static final double DEFAULT_MINIMUM_BALANCE = 1000.0; // Default minimum balance
    private double minimumBalance;

    public HighInterestSavings(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance, DEFAULT_INTEREST_RATE);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public HighInterestSavings(String accountNumber, String ownerName, String idNumber, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, ownerName, idNumber, balance, interestRate);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    

    @Override
    public void withdraw(double amount) throws IllegalBalanceException {
        if (this.balance - amount < minimumBalance) {
            throw new IllegalBalanceException("Withdrawal would result in balance below minimum");
        }
        super.withdraw(amount);
    }
}