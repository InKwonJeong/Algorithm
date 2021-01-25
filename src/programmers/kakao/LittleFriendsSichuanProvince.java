package programmers.kakao;

import java.util.*;

public class LittleFriendsSichuanProvince {
    public static void main(String[] args) {
        int[] m = {3, 2, 4, 2, 3, 3, 3, 3, 2};
        int[] n = {3, 4, 4, 2, 3, 3, 5, 3, 2};
        String[][] board = {
                {"DBA", "C*A", "CDB"},
                {"NRYN", "ARYA"},
                {".ZI.", "M.**", "MZU.", ".IU."},
                {"AB", "BA"},
                {"DAC", "BDC", "*BA"},
                {"BBA", "DDA", "CC*"},
                {"MA.AC", ".RM..", "...RC"},
                {"A..", "...", "*.A"},
                {"A*", "*A"}
        };
        for (int i = 0; i < m.length; i++) {
            System.out.println(new LittleFriendsSichuanProvince().solution(m[i], n[i], board[i]));
        }
    }

    private char[][] graph;
    private List<Tile> tiles;
    private int m, n;
    private Tile tile;
    private boolean[][] visit;
    private boolean finish;

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public String solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        graph = new char[m][n];
        tiles = new ArrayList<>();
        visit = new boolean[m][n];
        StringBuilder answer = new StringBuilder();

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = board[i].charAt(j);
                if (graph[i][j] >= 'A' && graph[i][j] <= 'Z') {
                    if (!set.contains(graph[i][j])) {
                        set.add(graph[i][j]);
                        tiles.add(new Tile(graph[i][j], i, j));
                    }
                }
            }
        }

        tiles.sort(Comparator.comparing(o -> o.c));

        finish = true;
        while (finish && !tiles.isEmpty()) {
            finish = false;
            for (Tile tile : tiles) {
                this.tile = tile;
                Point p = new Point(tile.x, tile.y, 2, 1);
                visit[tile.x][tile.y] = true;
                check(p);
                if (finish) {
                    answer.append(tile.c);
                    tiles.remove(tile);
                    visit[tile.x][tile.y] = false;
                    break;
                }
                visit[tile.x][tile.y] = false;
            }
        }

        if (finish)
            return answer.toString();
        else
            return "IMPOSSIBLE";
    }

    private void remove(int x1, int y1, int x2, int y2) {
        graph[x1][y1] = '.';
        graph[x2][y2] = '.';
    }

    private void check(Point p) {
        if (finish)
            return;

        int x = p.x;
        int y = p.y;
        int direction = p.d;
        int count = p.c;

        if (count > 2)
            return;


        if (!(x == tile.x && y == tile.y) && graph[x][y] == tile.c) {
            remove(tile.x, tile.y, x, y);
            finish = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;

            if (1 - (i / 2) == direction) {
                if (!visit[nx][ny] && (graph[nx][ny] == '.' || graph[nx][ny] == tile.c)) {
                    visit[nx][ny] = true;
                    check(new Point(nx, ny, i / 2, count + 1));
                    visit[nx][ny] = false;
                }
            } else {
                if (!visit[nx][ny] && (graph[nx][ny] == '.' || graph[nx][ny] == tile.c)) {
                    visit[nx][ny] = true;
                    check(new Point(nx, ny, i / 2, count));
                    visit[nx][ny] = false;
                }
            }
        }
    }

    static class Tile {
        char c;
        int x, y;

        public Tile(char c, int x, int y) {
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        int x, y, d, c; // d = 0 : 수직, 1 : 수평, 2 : 처음

        public Point(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}
