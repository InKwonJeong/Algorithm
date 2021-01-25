package programmers.practice;

import java.util.Arrays;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.deepToString(new TowerOfHanoi().solution(n)));
    }

    private int[][] answer;
    private int count = 0;

    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        move(1, 3, n);

        return answer;
    }

    private void move(int start, int end, int n) {
        if(n == 1) {
            answer[count++] = new int[]{start, end};
            return;
        }

        move(start, 6 - end - start, n - 1);
        answer[count++] = new int[]{start, end};
        move(6 - end - start, end, n - 1);
    }
}
