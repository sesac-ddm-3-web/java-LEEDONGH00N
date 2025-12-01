package ch7.delivery;

public class ShippingMain {

    public static void main(String[] args) {

        NormalItem book = new NormalItem("자바의 정석", 30000);
        Furniture chair = new Furniture("편한 의자", 100000);
        Grocery apple = new Grocery("유기농 사과", 15000);

        Item[] cart = {book, chair, apple};

        long totalPayment = 0;

        System.out.println("## 장바구니 ##");
        for (Item item : cart) {
            item.displayInfo();
            item.calculateDeliveryFee();
            item.calculateFinalPrice();
            long finalPrice = item.getFinalPrice();
            System.out.println("최종 결제 금액: " + finalPrice + "원");
            totalPayment += finalPrice;
            System.out.println("--------------------");
        }

        System.out.println(">> 총 결제 예정 금액: " + totalPayment + "원");
    }

}