package baekjoon.stage.ifstatement;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        if(a % 4 == 0 && (a % 100 != 0 || a % 400 == 0))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
