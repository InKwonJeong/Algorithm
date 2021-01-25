package baekjoon.dynamic;

import java.util.Scanner;

public class OrdinaryBackpack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int[][] d = new int[n + 1][k + 1];

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            w[i] = input.nextInt();
            v[i] = input.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = d[i - 1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
                if (j - w[i] >= 0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                }
            }
        }
        System.out.println(d[n][k]);
    }

}
