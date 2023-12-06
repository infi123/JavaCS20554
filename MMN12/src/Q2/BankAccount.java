package Q2;

abstract class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected String idNumber;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, String idNumber, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.idNumber = idNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws IllegalBalanceException {
        if (this.balance < amount) {
            throw new IllegalBalanceException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public abstract void monthlyManagement();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Owner: " + ownerName + ", ID: " + idNumber + ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BankAccount other = (BankAccount) obj;
        return accountNumber.equals(other.accountNumber) && ownerName.equals(other.ownerName) && idNumber.equals(other.idNumber) && balance == other.balance;
    }
}

class IllegalBalanceException extends Exception {
    public IllegalBalanceException(String message) {
        super(message);
    }
}