package baekjoon.stage.whilestatement;

import java.util.Scanner;

public class APlusB5 {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);

        while(true) {
            a = input.nextInt();
            b = input.nextInt();
            if(a==0 && b==0)
                break;
            System.out.println(a+b);
        }
    }
}
