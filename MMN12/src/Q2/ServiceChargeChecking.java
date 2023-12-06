package Q2;

class ServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_SERVICE_CHARGE = 10.0;
    private double serviceCharge;

    public ServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance) {
        super(accountNumber, ownerName, idNumber, balance);
        this.serviceCharge = DEFAULT_SERVICE_CHARGE;
    }

    public ServiceChargeChecking(String accountNumber, String ownerName, String idNumber, double balance, double serviceCharge) {
        super(accountNumber, ownerName, idNumber, balance);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void monthlyManagement() {
        try {
            this.withdraw(serviceCharge);
        } catch (IllegalBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}