package baekjoon.greedy;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String x = input.next();
        String y = input.next();

        int answer = 50;
        int l = y.length() - x.length();
        for(int i = 0; i <= l; i++) {
            int diff = 0;
            for(int j = 0; j < x.length(); j++) {
                if(x.charAt(j) != y.charAt(i + j))
                    diff++;
            }
            if(answer > diff)
                answer = diff;
        }
        System.out.println(answer);
    }
}

