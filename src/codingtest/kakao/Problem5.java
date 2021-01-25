package codingtest.kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        int[] n = {9, 9, 9};
        int[][][] path = {
                {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
                {{8, 1}, {0, 1}, {1, 2}, {0, 7}, {4, 7}, {0, 3}, {7, 5}, {3, 6}},
                {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}}
        };
        int[][][] order = {
                {{8, 5}, {6, 7}, {4, 1}},
                {{4, 1}, {5, 2}},
                {{4, 1}, {8, 7}, {6, 5}}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(new Problem5().solution(n[i], path[i], order[i]));
    }

    private List<Integer>[] paths;
    private boolean[] visit;
    private HashSet<Integer> visited_node;
    private boolean visit_finish, order_finish;
    private HashSet<Order> orders;

    public boolean solution(int n, int[][] path, int[][] order) {
        paths = new List[n];
        visit = new boolean[n];
        visited_node = new HashSet<>();
        orders = new HashSet<>();

        for (int i = 0; i < n; i++)
            paths[i] = new ArrayList<>();

        for (int[] p : path) {
            paths[p[0]].add(p[1]);
            paths[p[1]].add(p[0]);
        }
        for (int[] o : order) {
            orders.add(new Order(o[0], o[1]));
        }

        while (!orders.isEmpty()) {
            boolean finish = false;
            for (Order o : orders) {
                order_finish = true;
                visit_finish = false;
                travel(o.start, o.end);
                if (order_finish) {
                    orders.remove(o);
                    finish = true;
                    break;
                }
            }
            if(!finish)
                return false;
        }

        return true;
    }

    private void travel(int start, int end) {
        if(visit_finish)
            return;

        for (int node : paths[start]) {
            if(node == end) {
                visit_finish = true;
                for(Order order : orders) {
                    if(visited_node.contains(order.end)) {
                        order_finish = false;
                        break;
                    }
                }
                return;
            }

            if(!visit[node]) {
                visit[node] = true;
                visited_node.add(node);
                travel(node, end);
                visited_node.remove(node);
                visit[node] = false;
            }
        }
    }

    static class Order {
        int start, end;

        public Order(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
