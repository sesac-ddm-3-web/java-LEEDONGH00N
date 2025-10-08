package stream;

import java.util.Arrays;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
    }

}
