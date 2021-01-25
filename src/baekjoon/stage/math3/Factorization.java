package baekjoon.stage.math3;

import java.util.Scanner;

public class Factorization {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();

        while(true) {
            for(int i=2; i<=a; i++) {
                if(a % i == 0) {
                    System.out.println(i);
                    a /= i;
                    break;
                }
            }
            if(a == 1)
                break;
        }
    }
}
