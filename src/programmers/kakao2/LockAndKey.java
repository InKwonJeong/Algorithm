package programmers.kakao2;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(new LockAndKey().solution(key, lock));
    }

    private int[][][] keys;
    private int[][] bigger_lock;
    private int n, m, total;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        m = key.length;
        n = lock.length;
        keys = new int[4][m][m];

        keys[0] = key;
        keys[1] = rotate(keys[0]);
        keys[2] = rotate(keys[1]);
        keys[3] = rotate(keys[2]);

        bigger_lock = new int[3 * n][3 * n];
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                bigger_lock[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bigger_lock[n + i][n + j] = lock[i][j];
                if(lock[i][j] == 0)
                    total++;
            }
        }

        for (int i = 0; i <= bigger_lock.length - m; i++) {
            for (int j = 0; j <= bigger_lock.length - m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (check(i, j, keys[k]))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean check(int x, int y, int[][] key) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (bigger_lock[i + x][j + y] == 0 && key[i][j] == 1)
                    count++;

                if (bigger_lock[i + x][j + y] == 1 && key[i][j] == 1)
                    return false;
            }
        }
        return total == count;
    }

    private int[][] rotate(int[][] key) {
        int[][] rotate_key = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotate_key[i][j] = key[m - 1 - j][i];
            }
        }
        return rotate_key;
    }
}
