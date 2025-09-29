package sec2;

import java.util.Scanner;

public class 이자_계산기 {
    static final String principalInput = "원금을 입력하세요: ";
    static final String interestRateInput = "연이율(%)을 입력하세요: ";
    static final String yearsInput = "예치 기간(년)을 입력하세요: ";

    static final String resultOutput = "=== 최종 계산 결과 ===";
    static final String principalOutput = "원금: ";
    static final String interestRateOutput = "연이율: ";
    static final String yearsOutput = "기간: ";
    static final String divider = "--------------------";
    static final String totalProfitOutput = "총 이자 수익: ";
    static final String totalResultOutput = "최종 수령액: ";

    static final String currencyUnit = "원";
    static final String percentage = "%";
    static final String yearUnit = "년";

    public static void main(String[] args) {
        int principal;
        int years;
        double interestRate;
        Scanner scanner = new Scanner(System.in);
        System.out.print(principalInput);
        principal = scanner.nextInt();
        System.out.print(interestRateInput);
        interestRate = scanner.nextFloat();
        System.out.print(yearsInput);
        years = scanner.nextInt();
        int profit = calculateProfit(principal, interestRate, years);
        int result = profit + principal;
        System.out.println(resultOutput);
        System.out.println(principalOutput + changeNumberFormat(principal) + currencyUnit);
        System.out.println(interestRateOutput + interestRate + percentage);
        System.out.println(yearsOutput + years + yearUnit);
        System.out.println(divider);
        System.out.println(totalProfitOutput + changeNumberFormat(profit) + currencyUnit);
        System.out.println(totalResultOutput + changeNumberFormat(result) + currencyUnit);
    }

    private static int calculateProfit(int principal, double interestRate, int years) {
        return (int) (principal * (interestRate / 100) * years);
    }

    private static String changeNumberFormat(int num){
        return String.format("%,d", num);
    }
}
