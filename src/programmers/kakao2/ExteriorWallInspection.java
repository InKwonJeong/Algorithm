package programmers.kakao2;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        int[] n = {12, 12, 50};
        int[][] weak = {
                {1, 5, 6, 10},
                {1, 3, 4, 9, 10},
                {1, 5, 10, 12, 22, 25}
        };
        int[][] dist = {
                {1, 2, 3, 4},
                {3, 5, 7},
                {1, 2, 3},
                {4, 3, 2, 1}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(new ExteriorWallInspection().solution(n[i], weak[i], dist[i]));
    }

    private int n, answer;
    private int[] dist;
    private int[][] weaks;
    private int[] friends;
    private boolean[] visit;
    private boolean finish;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.dist = dist;
        answer = -1;
        visit = new boolean[dist.length];
        weaks = new int[weak.length][weak.length];
        weaks[0] = weak;
        for (int i = 1; i < weak.length; i++)
            weaks[i] = changeStart(weaks[i - 1]);

        for (int i = 1; i <= dist.length; i++) {
            if(!finish) {
                friends = new int[i];
                chooseFriends( 0);
            } else
                break;
        }

        return answer;
    }

    private void chooseFriends(int depth) {
        if(finish)
            return;

        if (friends.length == depth) {
            for (int[] weak : weaks) {
                if(check(weak)) {
                    answer = depth;
                    finish = true;
                    break;
                }
            }
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                friends[depth] = dist[i];
                chooseFriends(depth + 1);
                visit[i] = false;
            }
        }
    }

    private boolean check(int[] weak) {
        int start = weak[0];
        int index = 0;
        for (int i = 1; i < weak.length; i++) {
            int point = start + friends[index];
            if (point < weak[i]) {
                start = weak[i];
                index++;
                if (index >= friends.length)
                    return false;
            }
        }
        return true;
    }

    private int[] changeStart(int[] weak) {
        int[] new_weak = new int[weak.length];
        new_weak[weak.length - 1] = weak[0] + n;
        for (int i = 1; i < weak.length; i++) {
            new_weak[i - 1] = weak[i];
        }
        return new_weak;
    }
}
