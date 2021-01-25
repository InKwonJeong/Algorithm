package baekjoon.stage.brueforce;

import java.util.Scanner;

public class SumOfDecomposition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int answer = 0;
        for(int i = 1; i < n; i++) {
            if(sum(i) == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static int sum(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
