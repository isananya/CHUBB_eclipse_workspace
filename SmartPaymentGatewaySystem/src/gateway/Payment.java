package gateway;

import exceptions.TransactionFailedException;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment() throws TransactionFailedException;
}

