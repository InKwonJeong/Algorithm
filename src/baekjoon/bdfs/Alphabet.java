package baekjoon.bdfs;

import java.util.Scanner;

public class Alphabet {

    private static int[][] graph;
    private static int[] dx;
    private static int[] dy;
    private static boolean[] check;
    private static int answer = 0;

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n][m];
        check = new boolean[26];

        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - 'A';
            }
        }

        check[graph[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int count) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if(!check[graph[nx][ny]]) {
                check[graph[nx][ny]] = true;
                dfs(nx, ny, count + 1);
                check[graph[nx][ny]] = false;
            } else {
                if(answer < count)
                    answer = count;
            }
        }
    }
}
