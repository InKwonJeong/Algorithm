package baekjoon.stage.math2;

import java.util.Scanner;

public class Bertrand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            if(n == 0)
                break;

            System.out.println(count(n));
        }
    }

    private static int count(int n) {
        int count = 0;
        for(int i = n + 1; i <= 2 * n; i++) {
            boolean finish = true;
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    finish = false;
                    break;
                }
            }

            if(finish)
                count++;
        }
        return count;
    }
}
