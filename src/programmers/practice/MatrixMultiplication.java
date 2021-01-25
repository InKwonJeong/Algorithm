package programmers.practice;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][][] arr1 = {
                {{1, 4}, {3, 2}, {4, 1}},
                {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}
        };
        int[][][] arr2 = {
                {{3, 3}, {3, 3}},
                {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}
        };
        for(int i = 0; i < arr1.length; i++)
            System.out.println(Arrays.deepToString(new MatrixMultiplication().solution(arr1[i], arr2[i])));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int column1 = arr1[0].length;
        int row2 = arr2.length;
        int column2 = arr2[0].length;

        int[][] answer = new int[row1][column2];

        for(int i = 0; i < row1; i++) {
            for(int j = 0; j < column2; j++) {
                int value = 0;
                for(int k = 0; k < column1; k++) {
                    value += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = value;
            }
        }

        return answer;
    }
}
