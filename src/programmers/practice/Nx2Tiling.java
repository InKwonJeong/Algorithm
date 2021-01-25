package programmers.practice;

public class Nx2Tiling {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Nx2Tiling().solution(n));
    }

    public int solution(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007;
        }

        return d[n];
    }
}
