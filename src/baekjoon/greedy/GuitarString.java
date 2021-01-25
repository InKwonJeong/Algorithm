package baekjoon.greedy;

import java.util.Scanner;

public class GuitarString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        int six = input.nextInt();
        int one = input.nextInt();
        for(int i = 1; i < m; i++) {
            int s = input.nextInt();
            int o = input.nextInt();
            if(six > s)
                six = s;
            if(one > o)
                one = o;
        }

        int d = n / 6;
        int answer = n * one;
        for(int i = 1; i <= d + 1; i++) {
            int price = i * six;
            if(n - (6 * i) > 0)
                price += one * (n - (6 * i));
            if(answer > price)
                answer = price;
        }
        System.out.println(answer);
    }
}
