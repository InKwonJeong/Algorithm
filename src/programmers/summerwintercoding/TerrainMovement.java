package programmers.summerwintercoding;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TerrainMovement {
    public static void main(String[] args) {
        int[][][] land = {
                {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}},
                {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}},
                {{1, 3}, {5, 7}}
        };

        int[] height = {3, 1, 1};
        for (int i = 0; i < land.length; i++)
            System.out.println(new TerrainMovement().solution(land[i], height[i]));
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] land, group;
    private int[] parent;
    private boolean[][] visit;
    private int n, count, height;
    private Queue<Point> queue;
    private PriorityQueue<Edge> priorityQueue;

    public int solution(int[][] land, int height) {
        this.land = land;
        this.height = height;
        n = land.length;
        visit = new boolean[n][n];
        group = new int[n][n];
        queue = new LinkedList<>();
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        int answer = 0;

        grouping();
        makeNode();

        parent = new int[count + 1];
        for(int i = 1; i <= count; i++)
            parent[i] = i;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();

            int start = edge.start;
            int end = edge.end;
            int start_parent = find(start);
            int end_parent = find(end);
            if(start_parent == end_parent) // 간선을 연결하면 순환이 될 때
                continue;

            union(start, end);
            answer += edge.cost;
        }

        return answer;
    }

    private void makeNode() {
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if (!visit[nx][ny] && group[x][y] == group[nx][ny]) {
                                visit[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            } else if (group[x][y] < group[nx][ny]) {
                                priorityQueue.offer(
                                        new Edge(group[x][y], group[nx][ny], Math.abs(land[x][y] - land[nx][ny])));
                            }
                        }
                    }
                }
            }
        }
    }

    private void grouping() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    count++;
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;
                        group[x][y] = count;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if (!visit[nx][ny] && Math.abs(land[x][y] - land[nx][ny]) <= height) {
                                visit[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
        }
    }

    private int find(int node) {
        if(node == parent[node])
            return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 != root2)
            parent[root1] = node2;
    }

    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
