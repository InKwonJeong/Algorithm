package baekjoon.dynamic;

import java.util.Scanner;

public class DrunkSangBum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();
            int answer = 0;
            for(int i = 1; i <= n; i++) {
                int count = 0;
                for(int j = 1; j <= i / 2; j++) {
                    if(i % j == 0)
                        count++;
                }
                if(count % 2 == 0)
                    answer++;
            }
            System.out.println(answer);
            t--;
        }
    }
}
