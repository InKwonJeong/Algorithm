package programmers.practice;

public class Change {
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 5};
        System.out.println(new Change().solution(n, money));
    }

    public int solution(int n, int[] money) {
        int[] d = new int[n + 1];
        d[0] = 1;

        for(int m : money) {
            for(int i = m; i <= n; i++) {
                d[i] += d[i - m] % 1000000007;
            }
        }

        return d[n];
    }

}
