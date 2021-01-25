package programmers.summerwintercoding2;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int[][] A = {
                {5, 1, 3, 7},
                {2, 2, 2, 2}
        };
        int[][] B = {
                {2, 2, 6, 8},
                {1, 1, 1, 1}
        };
        for(int i = 0; i < A.length; i++)
            System.out.println(new NumberGame().solution(A[i], B[i]));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index = 0;
        for(int i = 0; i < B.length; i++) {
            if(A[index] < B[i]) {
                answer++;
                index++;
            }
        }

        return answer;
    }
}
