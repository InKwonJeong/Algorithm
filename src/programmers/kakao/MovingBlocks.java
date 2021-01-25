package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class MovingBlocks {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(new MovingBlocks().solution(board));
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] rotate_horizontal = {
            {0, 0, 1, -1, 1, 1},
            {0, 0, -1, -1, -1, 1},
            {-1, 1, 0, 0, -1, 0},
            {1, 1, 0, 0, 1, 0}
    };
    private int[][] rotate_vertical = {
            {0, 0, -1, -1, 1, -1},
            {0, 0, -1, 1, 1, 1},
            {1, -1, 0, 0, 0, -1},
            {1, 1, 0, 0, 0, 1}
    };

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][][] visit = new boolean[n][n][n][n];
        int answer = 0;

        Robot start_robot = new Robot(0, 0, 0, 1, 0, true);
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(start_robot);
        visit[start_robot.x1][start_robot.y1][start_robot.x2][start_robot.y2] = true;
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            if((robot.x1 == n - 1 && robot.y1 == n - 1) || (robot.x2 == n - 1 && robot.y2 == n - 1)) {
                answer = robot.dis;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int x1 = robot.x1 + dx[i];
                int y1 = robot.y1 + dy[i];
                int x2 = robot.x2 + dx[i];
                int y2 = robot.y2 + dy[i];
                if(x1 < 0 || x2 < 0 || x1 >= n || x2 >= n || y1 < 0 || y2 < 0 || y1 >= n || y2 >= n)
                    continue;
                if(!visit[x1][y1][x2][y2] && board[x1][y1] != 1 && board[x2][y2] != 1) {
                    queue.offer(new Robot(x1, y1, x2, y2, robot.dis + 1, robot.orientation));
                    visit[x1][y1][x2][y2] = true;
                }
            }

            if(robot.orientation) {
                for (int[] rotate : rotate_horizontal) {
                    int x1 = robot.x1 + rotate[0];
                    int y1 = robot.y1 + rotate[1];
                    int x2 = robot.x2 + rotate[2];
                    int y2 = robot.y2 + rotate[3];
                    int cross_x = robot.x1 + rotate[4];
                    int cross_y = robot.y1 + rotate[5];
                    if (x1 < 0 || x2 < 0 || x1 >= n || x2 >= n || y1 < 0 || y2 < 0 || y1 >= n || y2 >= n)
                        continue;
                    if (!visit[x1][y1][x2][y2] && board[x1][y1] != 1 && board[x2][y2] != 1 && board[cross_x][cross_y] != 1) {
                        queue.offer(new Robot(x1, y1, x2, y2, robot.dis + 1, !robot.orientation));
                        visit[x1][y1][x2][y2] = true;
                    }
                }
            } else {
                for (int[] rotate : rotate_vertical) {
                    int x1 = robot.x1 + rotate[0];
                    int y1 = robot.y1 + rotate[1];
                    int x2 = robot.x2 + rotate[2];
                    int y2 = robot.y2 + rotate[3];
                    int cross_x = robot.x1 + rotate[4];
                    int cross_y = robot.y1 + rotate[5];
                    if (x1 < 0 || x2 < 0 || x1 >= n || x2 >= n || y1 < 0 || y2 < 0 || y1 >= n || y2 >= n)
                        continue;
                    if (!visit[x1][y1][x2][y2] && board[x1][y1] != 1 && board[x2][y2] != 1 && board[cross_x][cross_y] != 1) {
                        queue.offer(new Robot(x1, y1, x2, y2, robot.dis + 1, !robot.orientation));
                        visit[x1][y1][x2][y2] = true;
                    }
                }
            }
        }

        return answer;
    }

    static class Robot {
        int x1, y1, x2, y2, dis;
        boolean orientation;

        public Robot(int x1, int y1, int x2, int y2, int dis, boolean orientation) {
            if(orientation) {
                if(y1 < y2) {
                    this.x1 = x1;
                    this.y1 = y1;
                    this.x2 = x2;
                    this.y2 = y2;
                }
                else {
                    this.x1 = x2;
                    this.y1 = y2;
                    this.x2 = x1;
                    this.y2 = y1;
                }
            } else {
                if(x1 < x2) {
                    this.x1 = x1;
                    this.y1 = y1;
                    this.x2 = x2;
                    this.y2 = y2;
                } else {
                    this.x1 = x2;
                    this.y1 = y2;
                    this.x2 = x1;
                    this.y2 = y1;
                }
            }
            this.dis = dis;
            this.orientation = orientation;
        }
    }

}
