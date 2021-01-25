package baekjoon.stage.minimumspanningtree;

import java.util.*;

public class PlanetTunnel {

    private static int[] parents;
    private static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        parents = new int[n + 1];
        List<Planet> planets = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            planets.add(new Planet(i, x, y, z));
            parents[i] = i;
        }

        planets.sort(Comparator.comparingInt(o -> o.x));

        List<Path> paths = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            int distance = Math.abs(planets.get(i).x - planets.get(i + 1).x);
            paths.add(new Path(planets.get(i).index, planets.get(i + 1).index, distance));
        }

        planets.sort(Comparator.comparingInt(o -> o.y));
        for(int i = 0; i < n - 1; i++) {
            int distance = Math.abs(planets.get(i).y - planets.get(i + 1).y);
            paths.add(new Path(planets.get(i).index, planets.get(i + 1).index, distance));
        }

        planets.sort(Comparator.comparingInt(o -> o.z));
        for(int i = 0; i < n - 1; i++) {
            int distance = Math.abs(planets.get(i).z - planets.get(i + 1).z);
            paths.add(new Path(planets.get(i).index, planets.get(i + 1).index, distance));
        }

        System.out.println(cost(paths));
    }

    private static long cost(List<Path> paths) {
        int count = 0;
        long cost = 0;
        paths.sort(Comparator.comparingInt(o -> o.distance));
        for(Path path : paths) {
            if(count == n - 1)
                break;

            int p1 = find(path.start);
            int p2 = find(path.end);

            if(p1 != p2) {
                union(p1, p2);
                cost += path.distance;
                count++;
            }
        }

        return cost;
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

    static class Path {
        int start, end, distance;

        public Path(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static class Planet {
        int index, x, y, z;

        public Planet(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
