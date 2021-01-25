package programmers.practice;

import java.util.HashSet;

public class Phonekemon {
    public static void main(String[] args) {
        int[][] nums = {
                {3, 1, 2, 3},
                {3, 3, 3, 2, 2, 4},
                {3, 3, 3, 2, 2, 2}
        };
        for(int[] num : nums)
            System.out.println(new Phonekemon().solution(num));
    }

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length / 2;
        for(int num : nums)
            set.add(num);

        if(set.size() > n)
            return n;
        else
            return set.size();
    }
}
