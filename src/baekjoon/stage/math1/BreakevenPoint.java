package baekjoon.stage.math1;

import java.util.Scanner;

public class BreakevenPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();

        if(b >= c)
            System.out.println(-1);
        else {
            long answer = 1;
            while ((a + b * answer) >= c * answer) {
                answer++;
            }
            System.out.println(answer);
        }
    }
}
