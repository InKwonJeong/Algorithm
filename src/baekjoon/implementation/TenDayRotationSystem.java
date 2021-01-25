package baekjoon.implementation;

import java.util.Scanner;

public class TenDayRotationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int answer = 0;
        for(int i = 0; i < 5; i++) {
            if(n == input.nextInt())
                answer++;
        }
        System.out.println(answer);
    }
}
