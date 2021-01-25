package programmers.dynamic;

public class TileOrnaments {
    public static void main(String[] args) {
        int[] N = {5, 6};
        for(int n : N)
            System.out.println(new TileOrnaments().solution(n));
    }

    public long solution(int N) {
        long[] d = new long[N + 1];
        long[] f = new long[N + 1];

        d[0] = 0;
        d[1] = 1;
        f[0] = 0;
        f[1] = 4;

        for(int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + d[i - 2];
            f[i] = 2 * (d[i] + d[i - 1]) + 2 * d[i];
        }

        return f[N];
    }
}
