package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 0;
        int index = 0;
        for(int i = 1; i <= 9; i++) {
            int a = input.nextInt();
            if(a > max) {
                max = a;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
