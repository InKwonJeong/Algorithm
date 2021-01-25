package programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}
        };
        System.out.println(Arrays.toString(new KakaoFriendsColoringBook().solution(m, n, picture)));
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visit = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    queue.offer(new Point(i, j));
                    visit[i][j] = true;
                    int area = 0;
                    while (!queue.isEmpty()) {
                        area++;
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                                continue;

                            if(!visit[nx][ny] && picture[x][y] == picture[nx][ny]) {
                                visit[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                    if(maxSizeOfOneArea < area)
                        maxSizeOfOneArea = area;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
