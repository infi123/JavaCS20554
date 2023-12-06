package Q2;

abstract class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance);
    }

    public void writeCheck(double amount) throws IllegalBalanceException {
        this.withdraw(amount);
    }
}