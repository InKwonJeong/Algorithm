package baekjoon.stage.minimumspanningtree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CreateConstellation {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        parents = new int[n + 1];
        Star[] stars = new Star[n + 1];
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
            double x = input.nextDouble();
            double y = input.nextDouble();
            stars[i] = new Star(i, x, y);
        }

        List<Path> paths = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                double distance =
                        Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
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

    static class Star {
        int index;
        double x, y;

        public Star(int index, double x, double y) {
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
