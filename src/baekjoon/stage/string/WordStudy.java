package baekjoon.stage.string;

import java.util.Scanner;

public class WordStudy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next().toLowerCase();
        int[] a = new int[26];
        for(char c : s.toCharArray()) {
            a[c - 'a']++;
        }

        int answer = 0;
        int index = 0;
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            int b = a[i];
            if (answer < b) {
                answer = b;
                index = i;
                count = 1;
            } else if (answer == b) {
                count++;
            }
        }
        if(count == 1)
            System.out.println((char) ('A' + index));
        else
            System.out.println("?");
    }
}
