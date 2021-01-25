package baekjoon.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.next();
        String b = input.next();
        int n = a.length();
        int m = b.length();
        int[][] d = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) != b.charAt(j - 1))
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                else
                    d[i][j] = d[i - 1][j - 1] + 1;
            }
        }

        System.out.println(d[n][m]);

        int x = 0;
        int y = 0;
        List<Character> list = new ArrayList<>();
        while (d[x][y] != d[n][m]) {
            if (d[x + 1][y] != d[x][y] && d[x][y + 1] != d[x][y]) {
                x++;
                y++;
                list.add(a.charAt(x));
            } else if (d[x + 1][y] == d[x][y]) {
                x++;
            } else if (d[x][y + 1] == d[x][y]) {
                y++;
            }
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}
