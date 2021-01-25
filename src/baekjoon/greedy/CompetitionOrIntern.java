package baekjoon.greedy;

import java.util.Scanner;

public class CompetitionOrIntern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();

        for(int i = 0; i < k; i++) {
            if(n >= m * 2)
                n--;
            else
                m--;
        }

        if(n / 2 > m)
            System.out.println(m);
        else
            System.out.println(n / 2);
    }
}
