package baekjoon.stage.minimumspanningtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SympathyWithGod {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        parents = new int[n + 1];
        Point[] points = new Point[n + 1];
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
            int x = input.nextInt();
            int y = input.nextInt();
            points[i] = new Point(i, x, y);
        }

        for(int i = 1; i <= m; i++) {
            int p1 = find(input.nextInt());
            int p2 = find(input.nextInt());

            if(p1 != p2)
                union(p1, p2);
        }

        List<Path> paths = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                double distance =
                        Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                paths.add(new Path(i, j, distance));
            }
        }
        paths.sort(Comparator.comparingDouble(o -> o.distance));

        double answer = 0;
        for(Path path : paths) {
            int p1 = find(path.start);
            int p2 = find(path.end);

            if(p1 != p2) {
                answer += path.distance;
                union(p1, p2);
            }
        }

        System.out.printf("%.2f\n", answer);
    }

    private static int find(int star) {
        int parent = parents[star];
        if(parent == star)
            return star;

        parents[star] = find(parent);
        return parents[star];
    }

    private static void union(int star1, int star2) {
        int p1 = find(star1);
        int p2 = find(star2);

        if(p1 != p2)
            parents[p1] = p2;
    }

    static class Point {
        int index, x, y;

        public Point(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

    static class Path {
        int start, end;
        double distance;

        public Path(int start, int end, double distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
