package baekjoon.stage.whilestatement;

import java.util.Scanner;

public class APlusB4 {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()) {
            a = input.nextInt();
            b = input.nextInt();
            System.out.println(a+b);
        }
    }
}
