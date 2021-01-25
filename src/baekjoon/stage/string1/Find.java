package baekjoon.stage.string1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Find {

    private static int[] pi;
    private static List<Integer> list;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String pattern = input.nextLine();

        initPi(pattern);
        kmp(text, pattern);
        System.out.println(list.size());
        for(int index : list)
            System.out.println(index);
    }

    private static void initPi(String pattern) {
        pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if(pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }
    }

    private static void kmp(String text, String pattern) {
        list = new LinkedList<>();
        int j = 0;
        for(int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    list.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}