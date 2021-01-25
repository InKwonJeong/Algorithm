package baekjoon.stage.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Airport {

    private static HashMap<Integer, Integer> parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int answer = 0;
        parents = new HashMap<>();
        while (p --> 0) {
            int gate = Integer.parseInt(br.readLine());
            int parent = find(gate);
            if(parent == 0)
                break;

            union(parent, parent - 1);
            answer++;
        }

        System.out.println(answer);
    }

    private static int find(int gate) {
        if(parents.get(gate) == null)
            return gate;

        int parent = parents.get(gate);
        parents.put(gate, find(parent));
        return parents.get(gate);
    }

    private static void union(int gate1, int gate2) {
        int parent1 = find(gate1);
        int parent2 = find(gate2);

        if(parent1 != parent2)
            parents.put(parent1, parent2);
    }
}
