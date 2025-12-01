package ch8.payment;

public interface Payment {
    void processPayment(double amount);

    default void printReceipt(double amount){
        System.out.printf("결제 금액: %d\n", (int) amount);
    }

    default boolean validateAmount(double amount){
        System.out.printf("금액 유효성 검사 통과: %d\n", (int)amount);
        return true;
    }
}
