package baekjoon.stage.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SortWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] a = new String[n];

        for(int i = 0; i < n; i++) {
            a[i] = input.next();
        }

        Arrays.sort(a, ((o1, o2) -> {
            if(o1.length() < o2.length())
                return -1;
            else if(o1.length() > o2.length())
                return 1;
            else
                return o1.compareTo(o2);
        }));

        HashSet<String> set = new HashSet<>();
        for(String s : a) {
            if(!set.contains(s)) {
                System.out.println(s);
                set.add(s);
            }
        }
    }
}
