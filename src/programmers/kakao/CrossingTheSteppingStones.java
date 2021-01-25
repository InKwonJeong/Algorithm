package programmers.kakao;

public class CrossingTheSteppingStones {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(new CrossingTheSteppingStones().solution(stones, k));
    }

    private int[] stones;
    private int k;

    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;

        int answer = 0;

        int start = min(stones);
        int end = max(stones);

        while (start <= end) {
            int mid = (start + end) / 2;
            if(pass(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean pass(int mid) {
        int max = 0;
        int count = 0;
        for (int stone : stones) {
            if (stone >= mid) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(max, count) < k;
    }

    private int max(int[] stones) {
        int max = 0;
        for (int stone : stones) {
            if (max < stone)
                max = stone;
        }
        return max;
    }

    private int min(int[] stones) {
        int min = Integer.MAX_VALUE;
        for (int stone : stones) {
            if (min > stone)
                min = stone;
        }
        return min;
    }
}
