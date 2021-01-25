package baekjoon.dynamic;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] m = new int[N];
        int[] c = new int[N];

        for(int i = 0; i < N; i++)
            m[i] = input.nextInt();

        int total = 0;
        for(int i = 0; i < N; i++) {
            c[i] = input.nextInt();
            total += c[i];
        }

        int[][] d = new int[N + 1][total + 1];
        for(int i = 0; i < N; i++) {
            int memory = m[i];
            int cost = c[i];
            for(int j = 0; j <= total; j++) {
                if(j >= cost)
                    d[i + 1][j] = Math.max(d[i][j], d[i][j - cost] + memory);
                else
                    d[i + 1][j] = d[i][j];
            }
        }

        int answer = 0;
        for(int i = 0; i <= total; i++) {
            if(d[N][i] >= M) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
