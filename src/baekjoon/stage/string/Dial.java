package baekjoon.stage.string;

import java.util.Scanner;

public class Dial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] alphabet = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        String s = input.next();
        int answer = 0;
        for(char c : s.toCharArray()) {
            answer += alphabet[(int) (c - 'A')];
        }
        System.out.println(answer);
    }
}
