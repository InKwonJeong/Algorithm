package baekjoon.greedy;

import java.util.Scanner;

public class LostParenthesis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.next();
        int answer = 0;
        int num = 0;
        boolean minus = false;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != '-' && c != '+') {
                num *= 10;
                num += c - '0';
            } else {
                if(minus)
                    answer -= num;
                else
                    answer += num;
                num = 0;

                if(c == '-')
                    minus = true;
            }
        }
        if(minus)
            answer -= num;
        else
            answer += num;

        System.out.println(answer);
    }
}
