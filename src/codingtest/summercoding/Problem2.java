package codingtest.summercoding;

public class Problem2 {
    public static void main(String[] args) {
        long[] n = {1, 4, 11, 8589934596L, 15, 16, 10000000000L};
        for(long a : n)
            System.out.println(new Problem2().solution(a));
    }

    private final long MAX = 10000000000L;
    private final int base = (int) (baseLog(MAX, 2) + 1);

    public long solution(long n) {
        long answer = 0;

        int d = base;
        while (n > 0) {
            long m = (long) Math.pow(2, d);
            if(n >= m) {
                answer += (long) Math.pow(3, d);
                n -= m;
            }
            d--;
        }

        return answer;
    }

    private double baseLog(double num, double base) {
        return Math.log(num) / Math.log(base);
    }
}
