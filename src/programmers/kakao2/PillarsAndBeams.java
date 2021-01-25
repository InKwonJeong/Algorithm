package programmers.kakao2;

import java.util.Arrays;

public class PillarsAndBeams {
    public static void main(String[] args) {
        int[] n = {5, 5};
        int[][][] build_frames = {
                {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}},
                {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(Arrays.deepToString(new PillarsAndBeams().solution(n[i], build_frames[i])));
    }

    private int count;
    private int n;
    private int[][] install, build_frame;

    public int[][] solution(int n, int[][] build_frame) {
        this.build_frame = build_frame;
        this.n = n;
        install = new int[n + 1][n + 1];

        for(int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];

            Loc[] locs = new Loc[13];
            locs[0] = new Loc(x, y);
            locs[1] = new Loc(x + 1, y + 1);
            locs[3] = new Loc(x + 1, y);
            locs[5] = new Loc(x + 1, y - 1);
            locs[6] = new Loc(x, y - 1);
            locs[7] = new Loc(x - 1, y - 1);
            locs[9] = new Loc(x - 1, y);
            locs[11] = new Loc(x - 1, y + 1);
            locs[12] = new Loc(x, y + 1);

            if(b == 1) { // 설치
                if(a == 0) { // 기둥
                    if(y == 0 || isBeam(locs[0]) || isBeam(locs[9]) || isPillar(locs[6])) {
                        count++;
                        install[x][y] += 1;
                    }
                } else { // 보
                    if(isPillar(locs[5]) || isPillar(locs[6]) || (isBeam(locs[3]) && isBeam(locs[9]))) {
                        count++;
                        install[x][y] += 2;
                    }
                }
            } else { // 삭제
                if(a == 0) { // 기둥
                    if(isPillar(locs[12])) {
                        if(!(isBeam(locs[11]) || isBeam(locs[12])))
                            continue;
                    }

                    if(isBeam(locs[11])) {
                        if(!(isPillar(locs[9]) || (isBeam(locs[12]) && isBeam(new Loc(x - 2, y + 1)))))
                            continue;
                    }

                    if(isBeam(locs[12])) {
                        if(!(isPillar(locs[3]) || (isBeam(locs[11]) && isBeam(locs[1]))))
                            continue;
                    }

                    count--;
                    install[x][y] -= 1;
                } else { // 보
                    if(isPillar(locs[0])) {
                        if(!(isPillar(locs[6]) || isBeam(locs[9])))
                            continue;
                    }

                    if(isPillar(locs[3])) {
                        if(!(isPillar(locs[5]) || isBeam(locs[3])))
                            continue;
                    }

                    if(isBeam(locs[3])) {
                        if(!(isPillar(locs[5]) || isPillar(new Loc(x + 2, y - 1))))
                            continue;
                    }

                    if(isBeam(locs[9])) {
                        if(!(isPillar(locs[6]) || isPillar(locs[7])))
                            continue;
                    }

                    count--;
                    install[x][y] -= 2;
                }
            }
        }

        int[][] answer = new int[count][3];
        int index = 0;
        for(int x = 0; x <= n; x++) {
            for(int y = 0; y <= n; y++) {
                if(install[x][y] == 1) {
                    answer[index][0] = x;
                    answer[index][1] = y;
                    answer[index][2] = 0;
                    index++;
                } else if(install[x][y] == 2) {
                    answer[index][0] = x;
                    answer[index][1] = y;
                    answer[index][2] = 1;
                    index++;
                } else if(install[x][y] == 3) {
                    answer[index][0] = x;
                    answer[index][1] = y;
                    answer[index][2] = 0;
                    index++;
                    answer[index][0] = x;
                    answer[index][1] = y;
                    answer[index][2] = 1;
                    index++;
                }
            }
        }

        return answer;
    }

    private boolean isPillar(Loc loc) {
        int x = loc.x;
        int y = loc.y;
        if(x < 0 || x > n || y < 0 || y >= n || !(install[x][y] == 1 || install[x][y] == 3))
            return false;
        else
            return true;
    }

    private boolean isBeam(Loc loc) {
        int x = loc.x;
        int y = loc.y;
        if(x < 0 || x >= n || y < 0 || y > n || !(install[x][y] == 2 || install[x][y] == 3))
            return false;
        else
            return true;
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
