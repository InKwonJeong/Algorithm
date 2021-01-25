package baekjoon.dynamic;

import java.util.Scanner;

public class GoDown {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] max = new int[3];
        int[] min = new int[3];

        for (int i = 0; i < n; i++) {
            int[] max_temp = copy(max);
            int[] min_temp = copy(min);
            for (int j = 0; j < 3; j++) {
                int num = input.nextInt();
                if(j == 0) {
                    max[j] = num + max(max_temp[j], max_temp[j + 1]);
                    min[j] = num + min(min_temp[j], min_temp[j + 1]);
                } else if(j == 2) {
                    max[j] = num + max(max_temp[j - 1], max_temp[j]);
                    min[j] = num + min(min_temp[j - 1], min_temp[j]);
                } else {
                    max[j] = num + max(max_temp[j - 1], max_temp[j], max_temp[j + 1]);
                    min[j] = num + min(min_temp[j - 1], min_temp[j], min_temp[j + 1]);
                }
            }
        }

        int max_answer = max[0];
        int min_answer = min[0];
        for(int i = 1; i < 3; i++) {
            if(max_answer < max[i])
                max_answer = max[i];
            if(min_answer > min[i])
                min_answer = min[i];
        }

        System.out.printf("%d %d", max_answer, min_answer);
    }

    private static int[] copy(int[] d) {
        int[] temp = new int[d.length];
        for(int i = 0; i < d.length; i++)
            temp[i] = d[i];
        return temp;
    }

    private static int max(int... value) {
        int max = value[0];
        for (int i = 1; i < value.length; i++) {
            if (max < value[i])
                max = value[i];
        }
        return max;
    }

    private static int min(int... value) {
        int min = value[0];
        for (int i = 1; i < value.length; i++) {
            if (min > value[i])
                min = value[i];
        }
        return min;
    }
}
