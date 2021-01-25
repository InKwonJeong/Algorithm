package baekjoon.stage.string1;

import java.util.Scanner;

public class StringSquared {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String pattern = input.next();
            if(pattern.equals("."))
                break;

            int[] pi = new int[pattern.length()];
            int j = 0;
            for(int i = 1; i < pattern.length(); i++) {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                    j = pi[j - 1];
                if(pattern.charAt(i) == pattern.charAt(j))
                    pi[i] = ++j;
            }

            if(pattern.length() % (pattern.length() - pi[pattern.length() - 1]) != 0)
                System.out.println(1);
            else
                System.out.println(pattern.length() / (pattern.length() - pi[pattern.length() - 1]));
        }
    }
}
