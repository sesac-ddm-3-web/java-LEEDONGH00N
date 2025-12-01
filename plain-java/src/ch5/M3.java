package ch5;

import java.util.Scanner;

public class M3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = (int) (Math.random() * 1000) + 1;
        System.out.println("정답 : " + answer);
        int attempt = 0;
        System.out.println("두꺼운 책의 아무 페이지나 펼쳤습니다. 몇 페이지일까요? (1~1000, 기회: 10번)");
        while(attempt++ < 10){
            System.out.printf("%d번째 시도: ", attempt);
            int myAnswer = scanner.nextInt();
            if(myAnswer == answer){
                System.out.println("정답입니다! 책을 찾았네요.");
                System.out.printf("축하합니다! %d번 만에 페이지를 찾았습니다.", attempt);
                break;
            }
            if(myAnswer > answer){
                System.out.println("더 앞장이에요! (Down!)");
            }
            else {
                System.out.println("더 뒷장이에요! (Up!)");
            }
        }
        if(attempt > 10){
            System.out.printf("아쉽네요. 모든 페이지를 넘겨봤지만 찾지 못했습니다. 정답은 %d쪽 입니다.", answer);
        }
    }
}
