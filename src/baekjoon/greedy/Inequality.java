package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Inequality {

    private static int n;
    private static String[] str;
    private static boolean[] check;
    private static List<String> nums;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        str = new String[n];
        check = new boolean[10];
        nums = new ArrayList<>();

        for(int i = 0; i < n; i++)
            str[i] = input.next();

        for(int i = 0; i <= 9; i++) {
            check[i] = true;
            dfs(String.valueOf(i), 0);
            check[i] = false;
        }

        Collections.sort(nums);
        System.out.println(nums.get(nums.size() - 1));
        System.out.println(nums.get(0));

    }

    private static void dfs(String num, int count) {
        if(count == n) {
            nums.add(num);
            return;
        }

        int digit = num.charAt(num.length() - 1) - '0';

        if(str[count].equals(">")) {
            for(int i = digit - 1; i >= 0; i--) {
                if(!check[i]) {
                    check[i] = true;
                    dfs(num + i, count + 1);
                    check[i] = false;
                }
            }
        } else {
            for(int i = digit + 1; i <= 9; i++) {
                if(!check[i]) {
                    check[i] = true;
                    dfs(num + i, count + 1);
                    check[i] = false;
                }
            }
        }
    }
}
