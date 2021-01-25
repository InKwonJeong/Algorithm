package baekjoon.stage.bisection;

import java.util.Arrays;
import java.util.Scanner;

public class CutLanLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        long answer = 0;

        int[] lines = new int[k];
        for(int i = 0; i < k; i++)
            lines[i] = input.nextInt();

        Arrays.sort(lines);
        long start = 1;
        long end = lines[k - 1];
        while (start <= end) {
            long mid = (start + end) / 2;
            int count = cut(lines, mid);
            if(count >= n) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int cut(int[] lines, long length) {
        int count = 0;
        for(int line : lines) {
            count += line / length;
        }
        return count;
    }
}
