package programmers.binarysearch;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(new Immigration().solution(n, times));
    }

    private int n;
    private int[] times;

    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long min = (start + end) / 2;
            if (isPassed(min)) {
                answer = min;
                end = min - 1;
            } else {
                start = min + 1;
            }
        }

        return answer;
    }

    private boolean isPassed(long num) {
        long count = 0;
        for (int time : times)
            count += num / time;

        return count >= n;
    }
}
