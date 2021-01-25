package programmers.kakao;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        int[] n = {12, 12};
        int[][] weak = {
                {1, 5, 6, 10},
                {1, 3, 4, 9, 10}
        };
        int[][] dist = {
                {1, 2, 3, 4},
                {3, 5, 7}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(new ExteriorWallInspection().solution(n[i], weak[i], dist[i]));
    }

    private int n, num;
    private int[] weak, dist, friends;
    private int[][] rotate_weak;
    boolean finish = false;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        setupRotateWeak();

        for (int i = 1; i <= dist.length; i++) {
            num = i;
            friends = new int[num];
            permutation(0, new boolean[dist.length]);
            if(finish)
                break;
        }

        return finish ? num : -1;
    }

    private void permutation(int count, boolean[] visit) {
        if(finish)
            return;

        if (count == num) {
            finish = check();
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                friends[count] = dist[i];
                permutation(count + 1, visit);
                visit[i] = false;
            }
        }
    }

    private boolean check() {
        for (int[] weak : rotate_weak) {
            boolean[] visit = new boolean[weak.length];
            int start = 0;
            int index = 0;
            while (index != num) {
                int friend = friends[index++];
                int i = start;
                for (int j = i; j < weak.length; j++) {
                    if (weak[i] + friend >= weak[j]) {
                        visit[j] = true;
                        start++;
                    }
                }
            }
            if (pass(visit))
                return true;
        }
        return false;
    }

    private boolean pass(boolean[] visit) {
        for (boolean v : visit)
            if (!v) return false;
        return true;
    }

    private void setupRotateWeak() {
        rotate_weak = new int[weak.length][weak.length];
        for (int i = 0; i < weak.length; i++) {
            for (int j = 0; j < weak.length; j++) {
                int index = i + j;
                if (index < weak.length)
                    rotate_weak[i][j] = weak[index];
                else
                    rotate_weak[i][j] = weak[index % weak.length] + n;
            }
        }
    }
}
