package ch8.payment;

public class Main {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment();
        Payment cash = new CashPayment();

        double amount1 = 50000;
        if (creditCard.validateAmount(amount1)) {
            creditCard.processPayment(amount1);
            System.out.println(); // 줄 바꿈
        }

        double amount2 = 30000;
        if (cash.validateAmount(amount2)) {
            cash.processPayment(amount2);
        }
    }
}
