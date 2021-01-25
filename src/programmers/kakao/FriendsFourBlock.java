package programmers.kakao;

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

        while (true) {
            int count = disappear();
            if(count == 0)
                break;
            answer += count;
            setting();
        }

        return answer;
    }

    private void setting() {
        for(int j = 0; j < n; j++) {
            for(int i = m - 2; i >= 0; i--) {
                if(graph[i][j] != 0) {
                    for(int k = i + 1; k < m; k++) {
                        if(graph[k][j] == 0) {
                            graph[k][j] = graph[k - 1][j];
                            graph[k - 1][j] = 0;
                        }
                    }
                }

            }
        }
    }

    private int disappear() {
        int count = 0;
        boolean[][] erase = new boolean[m][n];
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(graph[i][j] != 0) {
                    if(graph[i][j] != graph[i + 1][j])
                        continue;
                    if(graph[i][j] != graph[i][j + 1])
                        continue;
                    if(graph[i][j] != graph[i + 1][j + 1])
                        continue;

                    erase[i][j] = true;
                    erase[i + 1][j] = true;
                    erase[i][j + 1] = true;
                    erase[i + 1][j + 1] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(erase[i][j]) {
                    graph[i][j] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}
