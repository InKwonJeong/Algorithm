package programmers.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(new FunctionDevelopment().solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        boolean[] finish = new boolean[progresses.length];
        List<Integer> list = new ArrayList<>();
        int total = 0;
        while (total < progresses.length) {
            int count = 0;
            for(int i = 0; i < progresses.length; i++) {
                if(finish[i])
                    continue;

                progresses[i] += speeds[i];
                if(progresses[i] >= 100 && (i == 0 || finish[i - 1])) {
                    count++;
                    finish[i] = true;
                }
            }
            if(count != 0) {
                list.add(count);
                total += count;
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
