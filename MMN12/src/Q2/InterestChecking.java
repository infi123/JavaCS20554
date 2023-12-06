package Q2;

public class InterestChecking extends NoServiceChargeChecking {
    private static final double DEFAULT_INTEREST_RATE = 0.02; // 2% annual interest rate
    private double interestRate;

    public InterestChecking(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public InterestChecking(String accountNumber, String ownerName, String idNumber, double balance, double interestRate) {
        super(accountNumber, ownerName, idNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate / 12; // Monthly interest
    }

    @Override
    public void monthlyManagement() {
        double interest = calculateInterest();
        deposit(interest);
    }
}