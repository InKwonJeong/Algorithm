package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreakWallAndMove {

    private static int[] dx, dy;
    private static int n, m, answer;
    private static int[][] graph, visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, -1, 0, 1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n][m];
        visit = new int[n][m];
        answer = -1;

        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 1, 0));
        visit[0][0] = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.x == n - 1 && pair.y == m - 1) {
                answer = pair.dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                int dis = pair.dis;
                int count = pair.count;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(visit[nx][ny] <= count)
                    continue;

                if (graph[nx][ny] == 0) {
                    queue.offer(new Pair(nx, ny, dis + 1, count));
                    visit[nx][ny] = count;
                } else {
                    if(count == 0) {
                        queue.offer(new Pair(nx, ny, dis + 1, count + 1));
                        visit[nx][ny] = count + 1;
                    }
                }
            }
        }
    }

    static class Pair {
        int x, y, dis, count;

        Pair(int x, int y, int dis, int count) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.count = count;
        }
    }
}
