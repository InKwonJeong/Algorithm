package baekjoon.stage.forstatement;

import java.util.Scanner;

public class PrintN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = 1; i <= a; i++)
            System.out.println(i);
    }
}
