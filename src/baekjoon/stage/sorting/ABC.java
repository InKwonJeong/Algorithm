package baekjoon.stage.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] nums = new int[3];
        for(int i = 0; i < 3; i++)
            nums[i] = input.nextInt();

        Arrays.sort(nums);
        String order = input.next();

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        for(char o : order.toCharArray()) {
            if(o == 'A') {
                System.out.printf("%d ", a);
            } else if(o == 'B') {
                System.out.printf("%d ", b);
            } else {
                System.out.printf("%d ", c);
            }
        }
    }
}
