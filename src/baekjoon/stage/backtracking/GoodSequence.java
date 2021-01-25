package baekjoon.stage.backtracking;

import java.util.Scanner;

public class GoodSequence {

    private static int n;
    private static boolean finish;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        backtracking(0, "");
    }

    private static void backtracking(int depth, String str) {
        if(finish)
            return;

        if(depth == n) {
            System.out.println(str);
            finish = true;
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(isGood(str + i)) {
                backtracking(depth + 1, str + i);
            }
        }
    }

    private static boolean isGood(String str) {
        for(int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i);

            if(front.equals(back))
                return false;
        }
        return true;
    }
}
