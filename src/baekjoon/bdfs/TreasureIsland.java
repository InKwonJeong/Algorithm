package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreasureIsland {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int n = input.nextInt();
        int m = input.nextInt();
        char[][] graph = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 'L') {
                    int dis = 0;
                    boolean[][] visit = new boolean[n][m];
                    queue.offer(new Pair(i, j, 0));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();
                        dis = p.dis;
                        for(int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;
                            if(!visit[nx][ny] && graph[nx][ny] == 'L') {
                                queue.offer(new Pair(nx, ny, p.dis + 1));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    if(answer < dis)
                        answer = dis;
                }
            }
        }
        System.out.println(answer);
    }

    static class Pair {
        int x, y, dis;
        Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
