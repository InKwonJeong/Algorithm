package programmers.summerwintercoding;

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

        for(int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if(y + 1 <= 10) {
                        if(!visit[x][y][x][y + 1]) {
                            answer++;
                            visit[x][y][x][y + 1] = true;
                            visit[x][y + 1][x][y] = true;
                        }
                        y++;
                    }
                    break;
                case 'D':
                    if(y - 1 >= 0) {
                        if(!visit[x][y][x][y - 1]) {
                            answer++;
                            visit[x][y][x][y - 1] = true;
                            visit[x][y - 1][x][y] = true;
                        }
                        y--;
                    }
                    break;
                case 'R':
                    if(x + 1 <= 10) {
                        if(!visit[x][y][x + 1][y]) {
                            answer++;
                            visit[x][y][x + 1][y] = true;
                            visit[x + 1][y][x][y] = true;
                        }
                        x++;
                    }
                    break;
                case 'L':
                    if(x - 1 >= 0) {
                        if(!visit[x][y][x - 1][y]) {
                            answer++;
                            visit[x][y][x - 1][y] = true;
                            visit[x - 1][y][x][y] = true;
                        }
                        x--;
                    }
                    break;
            }
        }

        return answer;
    }
}
