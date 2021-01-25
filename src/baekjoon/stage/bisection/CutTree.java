package baekjoon.stage.bisection;

import java.util.Arrays;
import java.util.Scanner;

public class CutTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] trees = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++)
            trees[i] = input.nextInt();

        Arrays.sort(trees);
        int start = 0;
        int end = trees[n - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            long height = cut(trees, mid);
            if(height >= m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long cut(int[] trees, int height) {
        long tree_height = 0;
        for(int tree : trees) {
            if(tree > height)
                tree_height += tree - height;
        }
        return tree_height;
    }
}
