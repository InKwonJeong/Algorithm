package baekjoon.bdfs;

import java.util.*;

public class FindTheArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int m = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();

        int[][] graph = new int[n][m];
        boolean[][] check = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    graph[x][y] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> areas = new ArrayList<>();

        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0 && !check[i][j]) {
                    int area = 0;
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                    while (!queue.isEmpty()) {
                        area++;
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;
                        for(int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if(graph[nx][ny] == 0 && !check[nx][ny]) {
                                    queue.offer(new Point(nx, ny));
                                    check[nx][ny] = true;
                                }
                            }
                        }
                    }
                    areas.add(area);
                    count++;
                }
            }
        }

        Collections.sort(areas);
        System.out.println(count);
        for(int area : areas)
            System.out.printf("%d ", area);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
