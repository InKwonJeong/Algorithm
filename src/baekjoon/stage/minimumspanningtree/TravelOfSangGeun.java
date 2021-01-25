package baekjoon.stage.minimumspanningtree;

import java.util.Scanner;

public class TravelOfSangGeun {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int answer = 0;
            parents = new int[n + 1];
            for(int i = 1; i <= n; i++)
                parents[i] = i;

            while (m -- > 0) {
                int a = input.nextInt();
                int b = input.nextInt();
                int p1 = find(a);
                int p2 = find(b);

                if(p1 != p2) {
                    answer++;
                    union(p1, p2);
                }
            }

            System.out.println(answer);
        }
    }

    private static int find(int node) {
        int parent = parents[node];
        if(parent == node)
            return node;

        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 != parent2)
            parents[parent1] = parent2;
    }
}
