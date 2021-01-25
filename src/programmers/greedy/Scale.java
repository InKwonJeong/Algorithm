package programmers.greedy;

import java.util.Arrays;

public class Scale {
    public static void main(String[] args) {
        int[] weight = {3, 1, 6, 2, 7, 30, 1};
        System.out.println(new Scale().solution(weight));
    }

    public int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        for (int value : weight) {
            if (answer + 1 < value) {
                break;
            } else {
                answer += value;
            }
        }

        return ++answer;
    }
}
