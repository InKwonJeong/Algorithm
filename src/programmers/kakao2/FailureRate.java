package programmers.kakao2;

import java.util.Arrays;

public class FailureRate {
    public static void main(String[] args) {
        int[] N = {5, 4};
        int[][] stages = {
                {2, 1, 2, 6, 2, 4, 3, 3},
                {4, 4, 4, 4, 4}
        };
        for(int i = 0; i < N.length; i++) {
            System.out.println(Arrays.toString(new FailureRate().solution(N[i], stages[i])));
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] count = new int[N + 1];
        StageInfo[] info = new StageInfo[N];
        for(int stage : stages) {
            if(stage <= N)
                count[stage]++;
        }

        int total = stages.length;
        for(int i = 0; i < N; i++) {
            info[i] = new StageInfo(i + 1, (double) count[i + 1] / total);
            total -= count[i + 1];
        }

        Arrays.sort(info, (o1, o2) -> {
            if(o1.rate < o2.rate)
                return 1;
            else if(o1.rate > o2.rate)
                return -1;
            else
                return Integer.compare(o1.level, o2.level);
        });

        for(int i = 0; i < answer.length; i++)
            answer[i] = info[i].level;

        return answer;
    }

    static class StageInfo {
        int level;
        double rate;

        public StageInfo(int level, double rate) {
            this.level = level;
            this.rate = rate;
        }
    }
}
