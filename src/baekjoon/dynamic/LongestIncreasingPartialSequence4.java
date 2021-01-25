package baekjoon.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingPartialSequence4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] d = new int[n];
        int[] a = new int[n];
        List<Integer>[] sequences = new List[n];

        for(int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            sequences[i] = new ArrayList<>();
        }

        int answer_value = 1;
        int answer_index = 0;

        d[0] = 1;
        sequences[0].add(a[0]);
        for(int i = 1; i < n; i++) {
            int index = i;
            int value = 0;
            for(int j = 0; j < i; j++) {
                if(a[i] > a[j] && value < d[j]) {
                    value = d[j];
                    index = j;
                }
            }

            d[i] = value + 1;
            sequences[i].addAll(sequences[index]);
            sequences[i].add(a[i]);

            if(d[i] > answer_value) {
                answer_value = d[i];
                answer_index = i;
            }
        }

        System.out.println(answer_value);
        for(int value : sequences[answer_index])
            System.out.print(value + " ");
    }
}
