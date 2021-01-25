package programmers.practice;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        int[] n = {2, 2, 2};
        int[] s = {9, 1, 8};
        for(int i = 0; i < n.length; i++)
            System.out.println(Arrays.toString(new BestSet().solution(n[i], s[i])));
    }

    public int[] solution(int n, int s) {
        if(s < n)
            return new int[]{-1};

        int[] answer = new int[n];

        int index = 0;
        while (n > 0) {
            answer[index] = s / n;
            s -= answer[index];
            n--;
            index++;
        }

        return answer;
    }
}
