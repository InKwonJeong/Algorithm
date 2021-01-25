package programmers.summerwintercoding;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[][] d = {
                {1, 3, 2, 5, 4},
                {2, 2, 3, 3}
        };
        int[] budget = {9, 10};
        for(int i = 0; i < d.length; i++)
            System.out.println(new Budget().solution(d[i], budget[i]));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int total = 0;
        for(int b : d) {
            if(total + b <= budget) {
                answer++;
                total += b;
            } else
                break;
        }

        return answer;
    }
}
