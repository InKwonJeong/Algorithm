package baekjoon.stage.lowestcommonancestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestCommonAncestor {

    private static int[] heights, parents;
    private static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            int n = input.nextInt();
            int[] count = new int[n + 1];
            heights = new int[n + 1];
            parents = new int[n + 1];
            graph = new List[n + 1];
            for(int i = 1; i <= n; i++)
                graph[i] = new ArrayList<>();

            for(int i = 1; i < n; i++) {
                int parent = input.nextInt();
                int child = input.nextInt();
                graph[parent].add(child);
                count[child]++;
            }

            int node1 = input.nextInt();
            int node2 = input.nextInt();

            for(int i = 1; i <= n; i++) {
                if(count[i] == 0) {
                    dfs(i, 0, 1);
                    break;
                }
            }

            System.out.println(lca(node1, node2));
        }
    }

    private static int lca(int node1, int node2) {
        if(node1 == node2)
            return node1;

        if(heights[node1] == heights[node2]) {
            return lca(parents[node1], parents[node2]);
        } else {
            int h1 = heights[node1];
            int h2 = heights[node2];
            int n1 = node1;
            int n2 = node2;
            if(h1 > h2) {
                while (h1 > h2) {
                    n1 = parents[node1];
                    h1--;
                }
            } else {
                while (h2 > h1) {
                    n2 = parents[node2];
                    h2--;
                }
            }
            return lca(n1, n2);
        }
    }

    private static void dfs(int node, int parent, int height) {
        heights[node] = height;
        parents[node] = parent;

        for(int child : graph[node]) {
            dfs(child, node, height + 1);
        }
    }
}
