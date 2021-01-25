package programmers.binarysearch;

import java.util.Arrays;

public class SteppingStones {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(new SteppingStones().solution(distance, rocks, n));
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int start = 1;
        int end = distance;

        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = 0;
            int count = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    count++;
                } else {
                    prev = rock;
                }
            }

            if(distance - prev < mid)
                count++;

            if(count <= n) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}
