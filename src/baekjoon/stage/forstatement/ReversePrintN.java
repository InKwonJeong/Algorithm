package baekjoon.stage.forstatement;

import java.util.Scanner;

public class ReversePrintN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = a; i >= 1; i--)
            System.out.println(i);
    }
}
