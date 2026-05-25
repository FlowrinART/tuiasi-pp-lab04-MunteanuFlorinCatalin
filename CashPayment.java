package payment;

public class CashPayment implements PaymentMethod {

    private double availableAmount;

    public CashPayment(double amount) {
        this.availableAmount = amount;
    }

    @Override
    public boolean pay(double fee) {

        if (availableAmount >= fee) {
            availableAmount -= fee;
            return true;
        }

        return false;
    }
}