package ch5;

public class M2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;
        while(++i <= 5){
            sum = sum + i;
        }
        System.out.println("1부터 5까지의 합: " + sum);
    }
}
