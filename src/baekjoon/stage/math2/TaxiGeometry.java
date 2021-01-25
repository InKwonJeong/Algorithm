package baekjoon.stage.math2;

import java.util.Scanner;

public class TaxiGeometry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(Math.PI * Math.pow(n, 2));
        System.out.println(Math.pow(n, 2) + Math.pow(n, 2));
    }
}
