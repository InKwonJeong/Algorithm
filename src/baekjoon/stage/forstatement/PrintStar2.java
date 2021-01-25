package baekjoon.stage.forstatement;

import java.util.Scanner;

public class PrintStar2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = 1; i <= a; i++) {
            for(int j = 1; j <= a - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
