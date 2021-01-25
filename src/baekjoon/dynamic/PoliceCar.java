package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PoliceCar {

    private static int w;
    private static int[][] d;
    private static Point[] one, two;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());

        d = new int[w + 1][w + 1];
        for(int i = 0; i <= w; i++)
            Arrays.fill(d[i], -1);

        one = new Point[w + 1];
        two = new Point[w + 1];

        one[0] = new Point(1, 1);
        two[0] = new Point(n, n);

        for(int i = 1; i <= w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            one[i] = new Point(x, y);
            two[i] = new Point(x, y);
        }

        builder.append(function(0, 0)).append("\n");
        list = new ArrayList<>();
        tracking(0, 0);
        for(int num : list)
            builder.append(num).append("\n");

        System.out.println(builder);
    }

    private static int function(int w1, int w2) {
        if(w1 == w || w2 == w)
            return 0;

        if(d[w1][w2] != -1)
            return d[w1][w2];

        int next = Math.max(w1, w2) + 1;
        int distance1 = Math.abs(one[w1].x - one[next].x) + Math.abs(one[w1].y - one[next].y);
        int value1 = function(next, w2) + distance1;
        int distance2 = Math.abs(two[w2].x - two[next].x) + Math.abs(two[w2].y - two[next].y);
        int value2 = function(w1, next) + distance2;

        d[w1][w2] = Math.min(value1, value2);
        return d[w1][w2];
    }

    private static void tracking(int w1, int w2) {
        if(w1 == w || w2 == w)
            return;

        int next = Math.max(w1, w2) + 1;
        int distance1 = Math.abs(one[w1].x - one[next].x) + Math.abs(one[w1].y - one[next].y);
        int value1 = d[next][w2] + distance1;
        int distance2 = Math.abs(two[w2].x - two[next].x) + Math.abs(two[w2].y - two[next].y);
        int value2 = d[w1][next] + distance2;

        if(value1 > value2) {
            list.add(2);
            tracking(w1, next);
        } else {
            list.add(1);
            tracking(next, w2);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
