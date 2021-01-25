package programmers.kakao;

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

    private int size;
    private int[][] map;

    public int[][] solution(int n, int[][] build_frame) {
        size = n + 1;
        map = new int[size + 1][size + 1]; // 0: X, 1: 기둥, 2: 보, 3: 둘다
        int count = 0;

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            boolean pillar = build_frame[i][2] == 0;
            boolean install = build_frame[i][3] == 1;

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

            if (install) {
                if (pillar) {
                    if (y == 0 || isPillar(locs[6]) || isBeam(locs[0]) || isBeam(locs[9])) {
                        map[x][y] += 1;
                        count++;
                    }
                } else {
                    if (isPillar(locs[5]) || isPillar(locs[6]) || isBeam(locs[3]) && isBeam(locs[9])) {
                        map[x][y] += 2;
                        count++;
                    }
                }
            } else {
                if (pillar) {
                    if (isPillar(locs[12])) {
                        if (!(isBeam(locs[11]) || isBeam(locs[12])))
                            continue;
                    }

                    if (isBeam(locs[12])) {
                        if (!(isPillar(locs[3]) || isBeam(locs[11]) && isBeam(locs[1])))
                            continue;
                    }

                    if (isBeam(locs[11])) {
                        if (!(isPillar(locs[9]) || isBeam(locs[12]) && isBeam(new Loc(x - 2, y + 1))))
                            continue;
                    }

                    map[x][y] -= 1;
                } else {
                    if (isPillar(locs[0])) {
                        if (!(isPillar(locs[6]) || isBeam(locs[9])))
                            continue;
                    }

                    if (isPillar(locs[3])) {
                        if (!(isPillar(locs[5]) || isBeam(locs[3])))
                            continue;
                    }

                    if (isBeam(locs[3])) {
                        if (!(isPillar(locs[5]) || isPillar(new Loc(x + 2, y - 1))))
                            continue;
                    }

                    if (isBeam(locs[9])) {
                        if (!(isPillar(locs[6]) || isPillar(locs[7])))
                            continue;
                    }

                    map[x][y] -= 2;
                }
                count--;
            }
        }

        int[][] answer = new int[count][3];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index][2] = 0;
                    index++;
                } else if (map[i][j] == 2) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index][2] = 1;
                    index++;
                } else if (map[i][j] == 3) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index][2] = 0;
                    index++;
                    answer[index][0] = i;
                    answer[index][1] = j;
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
        if (x < 0 || x >= size || y < 0 || y >= size || !(map[x][y] == 1 || map[x][y] == 3))
            return false;
        return true;
    }

    private boolean isBeam(Loc loc) {
        int x = loc.x;
        int y = loc.y;
        if (x < 0 || x >= size || y < 0 || y >= size || !(map[x][y] == 2 || map[x][y] == 3))
            return false;
        return true;
    }

    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
