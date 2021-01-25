package baekjoon.stage.forstatement;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = 1; i <= 9; i++)
            System.out.printf("%d * %d = %d\n", a, i, a * i);
    }
}
