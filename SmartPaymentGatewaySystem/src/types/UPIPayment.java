package types;

import gateway.Payment;
import services.Retryable;
import exceptions.*;

public class UPIPayment extends Payment implements Retryable {
    private String upiPin;

    public UPIPayment(double amount, String upiPin) {
        super(amount);
        this.upiPin = upiPin;
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        try {
            if (amount <= 0) throw new InvalidAmountException("Amount must be positive");
            if (!"1234".equals(upiPin)) throw new InvalidCredentialsException("Invalid UPI PIN");
            System.out.println("UPIPayment of ₹" + amount + " successful.");
        } catch (Exception e) {
            throw new TransactionFailedException("UPIPayment failed", e);
        }
    }

    @Override
    public void retry() { System.out.println("Retrying UPIPayment..."); }
}
