package Q2;

class NoServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_MINIMUM_BALANCE = 100.0;
    private double minimumBalance;

    public NoServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public NoServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance, double minimumBalance) {
        super(accountNumber, ownerName, idNumber, balance);
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

    @Override
    public void monthlyManagement() {
        // No monthly management for this account type
    }
}