package baekjoon.stage.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SortInside {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char[] C = s.toCharArray();
        Arrays.sort(C);
        StringBuilder builder = new StringBuilder();
        builder.append(C);
        System.out.println(builder.reverse().toString());
    }
}
