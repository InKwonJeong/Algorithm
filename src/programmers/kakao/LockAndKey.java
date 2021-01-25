package programmers.kakao;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(new LockAndKey().solution(key, lock));
    }

    private int holes = 0;

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        int[][] big_lock = new int[n * 3][n * 3];
        for(int i = 0; i < big_lock.length; i++) {
            for(int j = 0; j < big_lock.length; j++) {
                big_lock[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                big_lock[i + n][j + n] = lock[i][j];
                if(lock[i][j] == 0)
                    holes++;
            }
        }

        for(int i = 0; i <= big_lock.length - m; i++) {
            for(int j = 0; j <= big_lock.length - m; j++) {
                for(int k = 0; k < 4; k++) {
                    if(check(i, j, big_lock, key))
                        return true;
                    key = rotate(key);
                }

            }
        }

        return false;
    }

    private boolean check(int x, int y, int[][] big_lock, int[][] key) {
        int count = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1 && big_lock[x + i][y + j] == 0)
                    count++;
                else if (key[i][j] == 1 && big_lock[x + i][y + j] == 1)
                    return false;
                else if (key[i][j] == 0 && big_lock[x + i][y + j] == 0) {
                    return false;
                }
            }
        }
        return count == holes;
    }

    private int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] new_key = new int[m][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                if(key[i][j] == 1)
                    new_key[j][m - 1 - i] = 1;
            }
        }
        return new_key;
    }
}


