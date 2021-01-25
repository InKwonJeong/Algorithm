package programmers.summerwintercoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Origami {
    public static void main(String[] args) {
        int[] N = {1, 2, 3};
        for(int n : N)
            System.out.println(Arrays.toString(new Origami().solution(n)));
    }

    public int[] solution(int n) {
        List<Integer>[] d = new List[n + 1];
        for(int i = 1; i <= n; i++)
            d[i] = new ArrayList<>();

        d[1].add(0);
        for(int i = 2; i <= n; i++) {
            List<Integer> prev = d[i - 1];
            for(int j = 0; j < prev.size(); j++) {
                int value = prev.get(j);
                d[i].add(value);
            }
            d[i].add(0);
            for(int j = prev.size() - 1; j >= 0; j--) {
                int value = prev.get(j);
                d[i].add(1 - value);
            }
        }

        int[] answer = new int[d[n].size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = d[n].get(i);
        return answer;
    }
}
