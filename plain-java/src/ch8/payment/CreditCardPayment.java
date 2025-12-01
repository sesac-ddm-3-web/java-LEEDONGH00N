package ch8.payment;

public class CreditCardPayment implements Payment{

    @Override
    public void processPayment(double amount) {
        System.out.printf("신용카드로 %d원 결제했습니다.\n", (int) amount);
        printReceipt(amount);
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("=== 신용카드 영수증 ===");
        Payment.super.printReceipt(amount);
        System.out.println("결제 완료");
    }
}
