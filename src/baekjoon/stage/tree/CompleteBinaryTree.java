package baekjoon.stage.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompleteBinaryTree {

    private static List<Integer>[] levels;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = (int) (Math.pow(2, k) - 1);
        int[] nodes = new int[n];
        for(int i = 0; i < n; i++)
            nodes[i] = input.nextInt();

        levels = new List[k + 1];
        for(int i = 1; i <= k; i++)
            levels[i] = new ArrayList<>();

        setTree(0, n - 1, nodes, 1);
        for(int i = 1; i <= k; i++) {
            for(int num : levels[i])
                System.out.printf("%d ", num);
            System.out.println();
        }
    }

    private static void setTree(int start, int end, int[] nodes, int level) {
        if(start <= end) {
            int index = (start + end) / 2;
            levels[level].add(nodes[index]);
            setTree(start, index - 1, nodes, level + 1);
            setTree(index + 1, end, nodes, level + 1);
        }
    }
}
