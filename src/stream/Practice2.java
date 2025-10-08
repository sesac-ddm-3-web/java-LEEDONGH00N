package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println(wordLengths); // [5, 6, 6, 4]
    }
}
