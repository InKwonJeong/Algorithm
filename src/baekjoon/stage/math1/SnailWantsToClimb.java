package baekjoon.stage.math1;

import java.util.Scanner;

public class SnailWantsToClimb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        long v = input.nextLong();

        long answer = (long) Math.ceil((double) (v - a) / (a - b));
        System.out.println(answer + 1);
    }
}
