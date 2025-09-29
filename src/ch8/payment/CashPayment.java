package ch8.payment;

public class CashPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.printf("현금으로 %d 결제했습니다.\n", (int) amount);
        printReceipt(amount);
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("=== 현금 영수증 ===");
        Payment.super.printReceipt(amount);
        System.out.println("거스름돈: 없음");
    }

    @Override
    public boolean validateAmount(double amount){
        return true;
    }
}
