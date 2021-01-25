package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int a = input.nextInt();
            if(a > max)
                max = a;
            if(a < min)
                min = a;
        }
        System.out.println(min + " " + max);
    }
}
