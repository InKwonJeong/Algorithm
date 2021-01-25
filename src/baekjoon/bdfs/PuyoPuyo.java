package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PuyoPuyo {

    private static int[] dx, dy;
    private static char[][] graph;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, -1, 0, 1};

        graph = new char[12][6];
        for(int i = 0; i < 12; i++) {
            String str = input.next();
            for(int j = 0; j < 6; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        while (puyo() != 0) {
            answer++;
            down();
        }
        System.out.println(answer);
    }

    private static void down() {
        for(int i = 10; i >= 0; i--) {
            for(int j = 0; j < 6; j++) {
                if(graph[i][j] != '.') {
                    for(int k = i + 1; k < 12; k++) {
                        if(graph[k][j] == '.') {
                            graph[k][j] = graph[k - 1][j];
                            graph[k - 1][j] = '.';
                        }
                    }
                }
            }
        }
    }

    private static int puyo() {
        int puyo = 0;
        boolean[][] visit = new boolean[12][6];
        List<Pair> list = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 11; i >= 0; i--) {
            for(int j = 0; j < 6; j++) {
                if(!visit[i][j] && graph[i][j] != '.') {
                    Pair now = new Pair(i, j);
                    queue.offer(now);
                    list.add(now);
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
                            if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
                                continue;
                            if(!visit[nx][ny] && graph[p.x][p.y] == graph[nx][ny]) {
                                Pair next = new Pair(nx, ny);
                                queue.offer(next);
                                list.add(next);
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    if(list.size() >= 4) {
                        puyo++;
                        for(Pair p : list) {
                            graph[p.x][p.y] = '.';
                        }
                    }
                    list.clear();
                }
            }
        }
        return puyo;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
