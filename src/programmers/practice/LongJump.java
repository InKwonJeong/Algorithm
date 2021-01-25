package programmers.practice;

public class LongJump {
    public static void main(String[] args) {
        int[] N = {4, 3};
        for(int n : N)
            System.out.println(new LongJump().solution(n));
    }

    public long solution(int n) {
        long[] d = new long[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 1]) % 1234567;
        }

        return d[n];
    }
}
