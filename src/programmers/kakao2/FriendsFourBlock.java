package programmers.kakao2;

import java.util.ArrayList;
import java.util.List;

public class FriendsFourBlock {
    public static void main(String[] args) {
        int[] m = {4, 6};
        int[] n = {5, 6};
        String[][] board = {
                {"CCBDE", "AAADE", "AAABF", "CCBBF"},
                {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}
        };
        for(int i = 0; i < m.length; i++)
            System.out.println(new FriendsFourBlock().solution(m[i], n[i], board[i]));
    }

    private char[][] graph;
    private int m, n, answer;
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        graph = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = board[i].charAt(j);
            }
        }

        while (removeBlock())
            setting();

        return answer;
    }

    private void setting() {
        for(int j = 0; j < n; j++) {
            for(int i = m - 2; i >= 0; i--) {
                if(graph[i][j] != 0) {
                    int k = i;
                    while (k < m - 1 && graph[k + 1][j] == 0) {
                        graph[k + 1][j] = graph[k][j];
                        graph[k][j] = 0;
                        k++;
                    }
                }
            }
        }
    }

    private boolean removeBlock() {
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                char c = graph[i][j];
                if(c != 0) {
                    if (c == graph[i + 1][j] && c == graph[i][j + 1] && c == graph[i + 1][j + 1])
                        list.add(new Point(i, j));
                }
            }
        }

        for(Point p : list) {
            int x = p.x;
            int y = p.y;
            if(graph[x][y] != 0) {
                graph[x][y] = 0;
                answer++;
            }
            if(graph[x + 1][y] != 0) {
                graph[x + 1][y] = 0;
                answer++;
            }
            if(graph[x][y + 1] != 0) {
                graph[x][y + 1] = 0;
                answer++;
            }
            if(graph[x + 1][y + 1] != 0) {
                graph[x + 1][y + 1] = 0;
                answer++;
            }
        }

        return !list.isEmpty();
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
