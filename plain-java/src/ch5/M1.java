package ch5;

import java.util.Scanner;

public class M1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (String input = ""; !input.equals("exit"); ){
            System.out.print("입력 (종료하려면 exit): ");
            input = scanner.next();
            System.out.println("사용자 입력: " + input);
        }
        System.out.println("프로그램을 종료합니다.");
    }

}
