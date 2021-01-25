package programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    public static void main(String[] args) {
        int[][] answers = {
                {1, 2, 3, 4, 5},
                {1, 3, 2, 4, 2}
        };
        for (int[] answer : answers)
            System.out.println(Arrays.toString(new MockExam().solution(answer)));
    }

    public int[] solution(int[] answers) {
        int[][] person = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] count = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == person[0][i % person[0].length])
                count[0]++;
            if(answers[i] == person[1][i % person[1].length])
                count[1]++;
            if(answers[i] == person[2][i % person[2].length])
                count[2]++;
        }

        int max = max(count);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (max == count[i])
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }

    private int max(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
        }
        return max;
    }
}
