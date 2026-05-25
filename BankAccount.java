package payment;

public class BankAccount {

    private double availableAmount;

    public BankAccount(double amount) {
        this.availableAmount = amount;
    }

    public boolean updateAmount(double value) {

        if (availableAmount + value >= 0) {
            availableAmount += value;
            return true;
        }

        return false;
    }
}