package payment;

public class CardPayment implements PaymentMethod {

    private BankAccount bankAccount;

    public CardPayment(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean pay(double fee) {

        return bankAccount.updateAmount(-fee);

    }
}