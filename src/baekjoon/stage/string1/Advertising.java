package baekjoon.stage.string1;

import java.util.Scanner;

public class Advertising {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String pattern = input.next();
        int[] pi = new int[pattern.length()];

        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];
            if(pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }

        System.out.println(pattern.length() - pi[pattern.length() - 1]);
    }
}
