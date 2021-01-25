package baekjoon.stage.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortCoordinate2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            Location[] a = new Location[n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[i] = new Location(x, y);
            }
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static class Location implements Comparable<Location> {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }

        @Override
        public int compareTo(Location o) {
            if (y > o.getY())
                return 1;
            else if (y == o.getY()) {
                if (x > o.getX())
                    return 1;
                else if (x == o.getX())
                    return 0;
                else
                    return -1;
            } else
                return -1;
        }
    }
}
