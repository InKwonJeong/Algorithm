package baekjoon.stage.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SetExpression {

    private static HashMap<Integer, Integer> parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new HashMap<>();
        while (m --> 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(a, b);
            } else {
                if(find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static int find(int node) {
        if(parents.get(node) == null)
            return node;

        int parent = parents.get(node);
        parents.put(node, find(parent));
        return parents.get(node);
    }

    private static void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent1 != parent2) {
            parents.put(parent1, parent2);
        }
    }
}
