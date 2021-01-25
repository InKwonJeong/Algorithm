package baekjoon.implementation;

import java.util.Scanner;

public class WaterRate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt(); // x의 리터당 요금
        int b = input.nextInt(); // y의 기본 요금
        int c = input.nextInt(); // y의 상한 사용량
        int d = input.nextInt(); // y의 리터당 추가 요금
        int p = input.nextInt(); // 한달 수도 사용량

        int x = a * p;
        int y = c >= p ? b : b + (p - c) * d;

        if(x > y)
            System.out.println(y);
        else
            System.out.println(x);
    }
}
