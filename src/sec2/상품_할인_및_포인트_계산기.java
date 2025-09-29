package sec2;

import java.util.Scanner;

public class 상품_할인_및_포인트_계산기 {

    static final String originalPriceInput = "상품의 원가를 입력하세요: ";
    static final String discountRateInput = "할인율(%)을 입력하세요: ";

    static final String receiptOutput = "=== 결제 정보 ===";
    static final String receiptOriginalPriceOutput = "상품 원가: ";
    static final String receiptDiscountRateOutput = "할인율: ";
    static final String divider = "--------------------";
    static final String receiptResultPriceOutput = "최종 결제 금액: ";
    static final String receiptPointOutput = "적립 포인트: ";

    static final String currencyUnit = "원";
    static final String percentage = "%";
    static final String pointUnit = "점";

    public static void main(String[] args) {
        int originalPrice;
        int priceResult;
        int point;
        double discountRate;
        Scanner scanner = new Scanner(System.in);
        System.out.print(originalPriceInput);
        originalPrice = scanner.nextInt();
        System.out.print(discountRateInput);
        discountRate = scanner.nextInt();
        priceResult = calculatePriceResult(originalPrice, discountRate);
        point = calculatePoint(priceResult);
        System.out.println(receiptOutput);
        System.out.println(receiptOriginalPriceOutput + changeNumberFormat(originalPrice) + currencyUnit);
        System.out.println(receiptDiscountRateOutput + changePercentageFormat(discountRate) + percentage);
        System.out.println(divider);
        System.out.println(receiptResultPriceOutput + changeNumberFormat(priceResult) + currencyUnit);
        System.out.println(receiptPointOutput + changeNumberFormat(point) + pointUnit);
    }

    private static int calculatePriceResult(int originalPrice, double discountRate) {
        int priceResult;
        priceResult = (int) (originalPrice * (1 - discountRate / 100));
        priceResult = (priceResult / 10) * 10;
        return priceResult;
    }

    private static int calculatePoint(int priceResult) {
        return priceResult >= 30000 ? priceResult * 5 / 100 : priceResult * 3 / 100;
    }

    private static String changePercentageFormat(double discountRate){
        return String.format("%.1f", discountRate);
    }

    private static String changeNumberFormat(int num){
        return String.format("%,d", num);
    }
}
