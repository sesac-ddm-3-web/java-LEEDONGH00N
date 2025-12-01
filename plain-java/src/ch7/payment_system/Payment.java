package ch7.payment_system;

public abstract class Payment {
    protected double amount;

    public Payment(long amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract void processPayment();
}
