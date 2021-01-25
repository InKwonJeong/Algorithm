package baekjoon.bdfs;

import java.util.*;

public class SafeArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = input.nextInt();
        int[][] graph = new int[n][n];
        List<Integer> heights = new ArrayList<>();
        List<Integer> safe_areas = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int height = input.nextInt();
                graph[i][j] = height;
                heights.add(height);
            }
        }

        Collections.sort(heights);
        int min = heights.get(0) - 1;
        int max = heights.get(n * n - 1) - 1;

        for(int h = min; h <= max; h++) {
            boolean[][] check = new boolean[n][n];
            int safe_area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][j] > h && !check[i][j]) {
                        safe_area++;
                        Queue<Point> queue = new LinkedList<>();
                        queue.offer(new Point(i, j));
                        check[i][j] = true;
                        while(!queue.isEmpty()) {
                            Point point = queue.poll();
                            for(int d = 0; d < 4; d++) {
                                int nx = point.x + dx[d];
                                int ny = point.y + dy[d];
                                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                    continue;

                                if(graph[nx][ny] > h && !check[nx][ny]) {
                                    queue.offer(new Point(nx, ny));
                                    check[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
            safe_areas.add(safe_area);
        }

        int answer = 0;
        for(int safe_area : safe_areas) {
            if(answer < safe_area)
                answer = safe_area;
        }
        System.out.println(answer);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
