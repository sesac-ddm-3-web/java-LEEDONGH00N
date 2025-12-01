package ch7.payment_system;

public class PaymentMain {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment(10000);
        Payment bankTransfer = new BankTransferPayment(50000);
        Payment mobilePay = new MobilePayment(30000);
        Payment[] payments = {creditCard, bankTransfer, mobilePay};

        double totalAmount = 0;

        System.out.println("## 결제 처리 시작 ##");
        System.out.println("--------------------");

        for (Payment payment : payments) {
            payment.processPayment();
            totalAmount += payment.getAmount();
        }

        System.out.println("--------------------");
        System.out.println(">> 총 결제 금액: " + totalAmount + "원");

    }
}
