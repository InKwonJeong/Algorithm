package programmers.summerwintercoding;

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

    private int P, Q;
    private int[] array;

    public long solution(int[][] land, int P, int Q) {
        this.P = P;
        this.Q = Q;
        int n = land.length;

        array = new int[n * n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                array[i * n + j] = land[i][j];

        Arrays.sort(array);
        int start = array[0];
        int end = array[n * n - 1];
        int mid = (start + end) / 2;

        while (start < end) {
            long c1 = getCost(mid);
            long c2 = getCost(mid + 1);
            if (c1 < c2) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        return getCost(mid);
    }

    private long getCost(long n) {
        long cost = 0;
        for (int l : array) {
            cost += ((n - l) >= 0 ? (n - l) * P : (l - n) * Q);
        }
        return cost;
    }
}
