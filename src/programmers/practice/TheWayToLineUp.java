package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheWayToLineUp {
    public static void main(String[] args) {
        int n = 4;
        long k = 6;
        System.out.println(Arrays.toString(new TheWayToLineUp().solution(n, k)));
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);

        k--;
        for(int i = 0; i < n; i++) {
            long fact = factorial(n - 1 - i);
            int index = (int) (k / fact);
            answer[i] = list.remove(index);
            k %= fact;
        }

        return answer;
    }

    private long factorial(int n) {
        long fact = 1;
        for(int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
}
