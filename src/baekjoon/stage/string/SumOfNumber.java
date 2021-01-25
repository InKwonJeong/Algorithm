package baekjoon.stage.string;

import java.util.Scanner;

public class SumOfNumber {
    public static void main(String[] args) {
        int T,sum;
        String s;
        String[] ss;
        Scanner input = new Scanner(System.in);

        T = input.nextInt();
        s = input.next();
        ss = s.split("");
        sum = 0;

        for(int i = 0; i < T; i++) {
            sum += Integer.parseInt(ss[i]);
        }
        System.out.println(sum);
    }
}
