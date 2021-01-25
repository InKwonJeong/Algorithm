package programmers.sort;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[][] numbers = {
                {6, 10, 2},
                {3, 30, 34, 5, 9}
        };
        for(int[] number : numbers)
            System.out.println(new LargestNumber().solution(number));
    }

    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++)
            nums[i] = String.valueOf(numbers[i]);

        Arrays.sort(nums, (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;

            return str2.compareTo(str1);
        });

        if(nums[0].equals("0"))
            return "0";

        StringBuilder answer = new StringBuilder();
        for(String num : nums) {
            answer.append(num);
        }

        return answer.toString();
    }
}
