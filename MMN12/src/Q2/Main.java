package Q2;

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new ServiceChargeChecking("123", "Alice", "ID1", 1000, 20);
        accounts[1] = new NoServiceChargeChecking("456", "Bob", "ID2", 2000, 500);
        accounts[2] = new InterestChecking("789", "Charlie", "ID3", 3000, 0.03);
        accounts[3] = new SavingsAccount("012", "Dave", "ID4", 4000, 0.02);
        accounts[4] = new HighInterestSavings("345", "Eve", "ID5", 5000, 0.05, 1000);

        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }

        for (BankAccount account : accounts) {
            try {
                account.deposit(Math.random() * 500);
                account.withdraw(Math.random() * 500);
            } catch (IllegalBalanceException e) {
                System.out.println("Illegal balance for account " + account.getAccountNumber() + ": " + e.getMessage());
            }
            System.out.println(account.toString());
        }

        for (BankAccount account : accounts) {
            account.monthlyManagement();
            System.out.println(account.toString());
        }
    }
}