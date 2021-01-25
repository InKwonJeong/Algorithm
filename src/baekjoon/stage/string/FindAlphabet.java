package baekjoon.stage.string;

import java.util.Scanner;

public class FindAlphabet {
    public static void main(String[] args) {
        String S;
        int[] frequency = new int[26];
        int index;

        Scanner input = new Scanner(System.in);
        S = input.next();

        for (int i = 0; i < frequency.length; i++)
            frequency[i] = -1;

        for (int i = 0; i < S.length(); i++) {
            index = (int) S.charAt(i) - 97;
            if (frequency[index] == -1)
                frequency[index] = i;
        }

        for (int i : frequency)
            System.out.print(i + " ");
    }
}
