package baekjoon.stage.tree;

import java.util.*;

public class DiameterOfTree {

    private static int n;
    private static List<Node>[] paths;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        paths = new List[n + 1];
        for(int i = 1; i <= n; i++)
            paths[i] = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            int node = input.nextInt();
            while (true) {
                int index = input.nextInt();
                if(index == -1)
                    break;

                int distance = input.nextInt();
                paths[node].add(new Node(index, distance));
            }
        }

        int[] distances = function(1);

        int index = 0;
        int distance = 0;
        for(int i = 1; i <= n; i++) {
            if(distance < distances[i]) {
                index = i;
                distance = distances[i];
            }
        }

        distances = function(index);
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(answer < distances[i])
                answer = distances[i];
        }

        System.out.println(answer);
    }

    private static int[] function(int start) {
        int[] distances = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        visit[start] = true;
        distances[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for(Node path : paths[node.index]) {
                if(!visit[path.index]) {
                    visit[path.index] = true;
                    distances[path.index] = node.distance + path.distance;
                    queue.offer(new Node(path.index, node.distance + path.distance));
                }
            }
        }

        return distances;
    }

    static class Node {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
