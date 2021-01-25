package baekjoon.stage.forstatement;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        System.out.println(a * (a + 1) / 2);
    }
}
