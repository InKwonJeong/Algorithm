package programmers.kakao;

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
        int[] count = new int[N + 2];
        Stage[] stage_array = new Stage[N];

        for (int stage : stages)
            count[stage]++;

        int total = stages.length;
        for(int i = 1; i <= stage_array.length; i++) {
            float rate = (float) count[i] / total;
            total -= count[i];
            stage_array[i - 1] = new Stage(i, rate);
        }

        Arrays.sort(stage_array, (o1, o2) -> {
            if(o1.rate > o2.rate)
                return -1;
            else if(o1.rate < o2.rate)
                return 1;
            else {
                return Integer.compare(o1.stage, o2.stage);
            }
        });

        for(int i = 0; i < answer.length; i++) {
            answer[i] = stage_array[i].stage;
        }

        return answer;
    }

    static class Stage {
        int stage;
        float rate;
        Stage(int stage, float rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
}
