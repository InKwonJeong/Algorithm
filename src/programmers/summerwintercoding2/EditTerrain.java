package programmers.summerwintercoding2;

import java.util.Arrays;

public class EditTerrain {
    public static void main(String[] args) {
        int[][][] land = {
                {{1, 2}, {2, 3}},
                {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}
        };
        int[] P = {3, 5};
        int[] Q = {2, 3};
        for (int i = 0; i < land.length; i++) {
            System.out.println(new EditTerrain().solution(land[i], P[i], Q[i]));
        }
    }

    private int[] d;
    private int P, Q, n;
    public long solution(int[][] land, int P, int Q) {
        long answer = -1;
        this.P = P;
        this.Q = Q;
        n = land.length;
        d = new int[n * n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                d[i * n + j] = land[i][j];
            }
        }

        Arrays.sort(d);
        int start = d[0];
        int end = d[d.length - 1];
        while (start <= end) {
            int mid = (int) (((long) start + end) / 2);
            long cost1 = cost(mid);
            long cost2 = cost(mid + 1);

            if(cost1 > cost2) {
                answer = cost2;
                start = mid + 1;
            } else {
                answer = cost1;
                end = mid - 1;
            }
        }

        return answer;
    }

    private long cost(int height) {
        long cost = 0;
        for(int b : d) {
            if(b < height) {
                cost += (long) (height - b) * P;
            } else if(b > height) {
                cost += (long) (b - height) * Q;
            }
        }
        return cost;
    }
}
