package programmers.summerwintercoding2;

public class VisitLength {
    public static void main(String[] args) {
        String[] dirs = {
                "ULURRDLLU",
                "LULLLLLLU"
        };
        for(String dir : dirs)
            System.out.println(new VisitLength().solution(dir));
    }

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visit = new boolean[11][11][11][11];
        int x = 5;
        int y = 5;
        for(char c : dirs.toCharArray()) {
            if(c == 'U') {
                if(y + 1 <= 10) {
                    if (!visit[x][y][x][y + 1]) {
                        visit[x][y][x][y + 1] = true;
                        visit[x][y + 1][x][y] = true;
                        answer++;
                    }
                    y++;
                }
            } else if(c == 'D') {
                if(y - 1 >= 0) {
                    if (!visit[x][y][x][y - 1]) {
                        visit[x][y][x][y - 1] = true;
                        visit[x][y - 1][x][y] = true;
                        answer++;
                    }
                    y--;
                }
            } else if(c == 'R') {
                if(x + 1 <= 10) {
                    if (!visit[x][y][x + 1][y]) {
                        visit[x][y][x + 1][y] = true;
                        visit[x + 1][y][x][y] = true;
                        answer++;
                    }
                    x++;
                }
            } else {
                if(x - 1 >= 0) {
                    if (!visit[x][y][x - 1][y]) {
                        visit[x][y][x - 1][y] = true;
                        visit[x - 1][y][x][y] = true;
                        answer++;
                    }
                    x--;
                }
            }
        }

        return answer;
    }
}
