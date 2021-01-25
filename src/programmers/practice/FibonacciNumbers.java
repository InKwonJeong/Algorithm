package programmers.practice;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int[] N = {3, 5};
        for(int n : N)
            System.out.println(new FibonacciNumbers().solution(n));
    }

    public int solution(int n) {
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 1]) % 1234567;
        }
        return d[n];
    }
}
