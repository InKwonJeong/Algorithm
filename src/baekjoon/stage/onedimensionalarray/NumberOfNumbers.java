package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class NumberOfNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] count = new int[10];
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int nums = a * b * c;
        while(nums > 0) {
            count[nums % 10]++;
            nums /= 10;
        }

        for(int num : count)
            System.out.println(num);
    }
}
