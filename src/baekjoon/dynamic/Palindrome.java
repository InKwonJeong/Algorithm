package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            d[i][i] = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i + 1]) {
                d[i][i + 1] = 1;
                d[i + 1][i] = 1;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (a[j] == a[j + i] && d[j + 1][j + i - 1] == 1) {
                    d[j][j + i] = 1;
                    d[j + i][j] = 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            builder.append(d[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.println(builder);
    }
}
