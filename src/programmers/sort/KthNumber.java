package programmers.sort;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        System.out.println(Arrays.toString(new KthNumber().solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] subarray = new int[command[1] - command[0] + 1];
            for (int j = 0; j < subarray.length; j++) {
                subarray[j] = array[j + command[0] - 1];
            }
            Arrays.sort(subarray);
            answer[i] = subarray[command[2] - 1];
        }
        return answer;
    }
}
