package programmers.stackandqueue;

import java.util.Arrays;

public class Tower {
    public static void main(String[] args) {
        int[][] heights = {
                {6, 9, 5, 7, 4},
                {3, 9, 9, 3, 5, 7, 2},
                {1, 5, 3, 6, 7, 6, 5}
        };
        for(int[] height : heights)
            System.out.println(Arrays.toString(new Tower().solution(height)));
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
