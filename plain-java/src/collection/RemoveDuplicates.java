package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public Set<Integer> solution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
//        Set<Integer> set = Arrays.stream(arr)   // IntStream
//                .boxed()       // int → Integer
//                .collect(Collectors.toSet());
        return set;
    }

    public static void main(String[] args) {
        RemoveDuplicates solver = new RemoveDuplicates();
        int[] arr = {1, 2, 5, 2, 4, 5, 1, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Unique List: " + solver.solution(arr)); // 예상 출력: [1, 2, 4, 5, 6] (순서는 다를 수 있음)
    }
}
