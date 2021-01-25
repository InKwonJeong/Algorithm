package baekjoon.stage.function;

import java.util.Scanner;

public class Hansu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int answer = 0;
        for(int i = 1; i <= a; i++) {
            if(check(i))
                answer++;
        }
        System.out.println(answer);
    }

    private static boolean check(int n) {
        if(n < 100)
            return true;

        String number = String.valueOf(n);
        int diff = number.charAt(0) - number.charAt(1);
        for(int i = 1; i < number.length() - 1; i++) {
            char a = number.charAt(i);
            char b = number.charAt(i + 1);
            if(diff != a - b)
                return false;
        }
        return true;
    }
}
