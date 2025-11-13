package types;

import gateway.Payment;
import services.Refundable;
import services.Retryable;
import exceptions.*;

public class CreditCardPayment extends Payment implements Refundable, Retryable {
    public CreditCardPayment(double amount) { super(amount); }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Amount must be positive");
            if (amount > 50000) throw new PaymentGatewayTimeoutException("Credit Card gateway timeout");
            System.out.println("CreditCardPayment of ₹" + amount + " successful.");
        } catch (Exception e) {
            throw new TransactionFailedException("CreditCardPayment failed", e);
        }
    }

    @Override
    public void refund() { System.out.println("CreditCardPayment refunded: ₹" + amount); }

    @Override
    public void retry() { System.out.println("Retrying CreditCardPayment..."); }
}
