package programmers.practice;

import java.util.Arrays;

public class MakeTheMinimum {
    public static void main(String[] args) {
        int[][] A = {
                {1, 4, 2},
                {1, 2}
        };
        int[][] B = {
                {5, 4, 4},
                {3, 4}
        };
        for(int i = 0; i < A.length; i++)
            System.out.println(new MakeTheMinimum().solution(A[i], B[i]));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }
}
