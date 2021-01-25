package baekjoon.bdfs;

import java.util.*;

public class ApartmentNumbering {

    private static int n;
    private static int[][] map;
    private static boolean[][] check;

    private static int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
    private static int[] dy = {0, -1, 0, 1}; // 오른쪽, 아래, 왼쪽, 위

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> counts = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    counts.add(numbering(i, j));
                }
            }
        }

        Collections.sort(counts);
        System.out.println(counts.size());
        for(Integer count : counts)
            System.out.println(count);
    }

    private static int numbering(int x, int y) {
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        check[x][y] = true;
        while (!queue.isEmpty()) {
            count++;
            Point point = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (map[nx][ny] == 1 && !check[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    check[nx][ny] = true;
                }
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}