package baekjoon.bdfs;

import java.util.*;

public class Laboratory {

    static int[][] graph, temp;
    static int n, m, max;
    static List<Point> virus =  new ArrayList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();

        graph = new int[n][m];
        temp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = input.nextInt();
                if(graph[i][j] == 2)
                    virus.add(new Point(i, j));
            }
        }

        setWall(0, 0);
        System.out.println(max);
    }

    private static void setWall(int start, int count) {
        if(count == 3) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    temp[i][j] = graph[i][j];
                }
            }

            Queue<Point> queue = new LinkedList<>();
            for(Point point : virus)
                queue.offer(point);

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if(temp[nx][ny] == 0) {
                            temp[nx][ny] = 2;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            int safe = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(temp[i][j] == 0)
                        safe++;
                }
            }

            if(max < safe)
                max = safe;

            return;
        }

        // Core Code
        for(int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if(graph[x][y] == 0) {
                graph[x][y] = 1;
                setWall(i + 1, count + 1);
                graph[x][y] = 0;
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
