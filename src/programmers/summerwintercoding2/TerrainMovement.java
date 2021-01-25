package programmers.summerwintercoding2;

import java.util.*;

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

    private int n, height, group;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] land, graph;
    private List<Edge> edges;
    private int[] parent;

    public int solution(int[][] land, int height) {
        int answer = 0;
        this.land = land;
        this.height = height;
        n = land.length;
        group = -1;
        graph = new int[n][n];
        edges = new ArrayList<>();

        grouping();
        makeEdge();

        edges.sort(Comparator.comparingInt(o -> o.cost));
        parent = new int[group + 1];
        for(int i = 0; i <= group; i++)
            parent[i] = i;

        for(Edge edge : edges) {
            int node1 = edge.n1;
            int node2 = edge.n2;
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 == root2)
                continue;

            union(node1, node2);
            answer += edge.cost;
        }

        return answer;
    }

    private int find(int node) {
        if(parent[node] == node)
            return node;

        parent[node] = find(parent[node]);
        return parent[node];
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 != root2)
            parent[root1] = root2;
    }

    private void makeEdge() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;

                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if(!visit[nx][ny] && graph[x][y] == graph[nx][ny]) {
                                visit[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            } else if(graph[x][y] < graph[nx][ny]) {
                                edges.add(new Edge(
                                        graph[x][y], graph[nx][ny], Math.abs(land[x][y] - land[nx][ny])
                                ));
                            }
                        }
                    }
                }
            }
        }
    }

    private void grouping() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    group++;
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    graph[i][j] = group;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;

                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if(!visit[nx][ny] && Math.abs(land[x][y] - land[nx][ny]) <= height) {
                                visit[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                                graph[nx][ny] = group;
                            }
                        }
                    }
                }
            }
        }
    }

    static class Edge {
        int n1;
        int n2;
        int cost;

        public Edge(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
