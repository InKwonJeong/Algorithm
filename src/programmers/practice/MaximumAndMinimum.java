package programmers.practice;

import java.util.Arrays;

public class MaximumAndMinimum {
    public static void main(String[] args) {
        String[] S = {
                "1 2 3 4",
                "-1 -2 -3 -4",
                "-1 -1"
        };
        for(String s : S)
            System.out.println(new MaximumAndMinimum().solution(s));
    }

    public String solution(String s) {
        String[] nums = s.split(" ");
        int[] num = new int[nums.length];
        for(int i = 0; i < num.length; i++)
            num[i] = Integer.parseInt(nums[i]);

        Arrays.sort(num);

        return String.format("%d %d", num[0], num[num.length - 1]);
    }
}
