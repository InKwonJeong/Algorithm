package baekjoon.stage.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NetworkConnection {

    private static int[] parents, distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            distances = new int[n + 1];
            parents = new int[n + 1];
            for(int i = 1; i <= n; i++)
                parents[i] = i;

            while (true) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("O"))
                    break;
                else if(command.equals("E")) {
                    int I = Integer.parseInt(st.nextToken());
                    find(I);
                    System.out.println(distances[I]);
                } else {
                    int I = Integer.parseInt(st.nextToken());
                    int J = Integer.parseInt(st.nextToken());
                    union(I, J);
                }
            }
        }
    }

    private static int find(int node) {
        int parent = parents[node];
        if(parent == node)
            return node;

        parents[node] = find(parent);
        distances[node] += distances[parent];

        return parents[node];
    }

    private static void union(int I, int J) {
        parents[I] = J;
        distances[I] = Math.abs(I - J) % 1000;
    }
}
