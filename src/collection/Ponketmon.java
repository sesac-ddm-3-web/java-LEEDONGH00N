package collection;

import java.util.HashSet;
import java.util.Set;

public class Ponketmon {

    public int solution(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() <= size/2) {
            return set.size();
        }
        return size/2;
    }

    public static void main(String[] args) {
        Ponketmon solver = new Ponketmon();
        int[] nums1 = {3, 1, 2, 3};
        System.out.println("Case 1: " + solver.solution(nums1)); // 예상 출력: 2

        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println("Case 2: " + solver.solution(nums2)); // 예상 출력: 3
    }
}