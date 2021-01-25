package baekjoon.stage.math2;

import java.util.Arrays;
import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int[] a = new int[3];
            for(int i = 0; i < 3; i++)
                a[i] = input.nextInt();

            if(a[0] == 0 && a[1] == 0 && a[2] == 0)
                break;

            Arrays.sort(a);

            if(Math.pow(a[2], 2) == Math.pow(a[0], 2) + Math.pow(a[1], 2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
