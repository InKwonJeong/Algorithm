package baekjoon.stage.topologicalsort;

import java.util.*;

public class ChessTournament {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] count = new int[n];
        parents = new int[n];
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            graph[i] = new ArrayList<>();
        }

        List<Order> orders = new ArrayList<>();
        while (m --> 0) {
            int a = input.nextInt();
            String symbol = input.next();
            int b = input.nextInt();

            if(symbol.equals("=")) {
                int p1 = find(a);
                int p2 = find(b);

                if(p1 != p2)
                    union(p1, p2);
            } else {
                orders.add(new Order(a, b));
            }
        }

        for(Order order : orders) {
            int p1 = find(order.a);
            int p2 = find(order.b);

            graph[p1].add(p2);
            count[p2]++;
        }

        int size = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(i == parents[i]) {
                size++;
                if(count[i] == 0)
                    queue.offer(i);
            }
        }

        List<Integer> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes.add(node);

            for(int other : graph[node]) {
                count[other]--;
                if(count[other] == 0)
                    queue.offer(other);
            }
        }

        if(size == nodes.size())
            System.out.println("consistent");
        else
            System.out.println("inconsistent");
    }

    private static int find(int node) {
        if(parents[node] == node)
            return node;

        int parent = parents[node];
        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if(p1 != p2)
            parents[p1] = p2;
    }

    static class Order {
        int a, b;

        public Order(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
