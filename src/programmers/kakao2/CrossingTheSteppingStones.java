package programmers.kakao2;

public class CrossingTheSteppingStones {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(new CrossingTheSteppingStones().solution(stones, k));
    }

    private int k;
    public int solution(int[] stones, int k) {
        this.k = k;
        int answer = 0;

        int start = min(stones);
        int end = max(stones);
        while (start <= end) {
            int mid = (start + end) / 2;
            if(check(stones, mid)) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int[] stones, int value) {
        int count = 0;
        for(int stone : stones) {
            if(stone < value) {
                count++;
                if(count >= k)
                    return false;
            } else
                count = 0;
        }
        return true;
    }

    private int min(int[] stones) {
        int min = stones[0];
        for (int i = 1; i < stones.length; i++)
            if (min > stones[i])
                min = stones[i];
        return min;
    }

    private int max(int[] stones) {
        int max = stones[0];
        for (int i = 1; i < stones.length; i++)
            if (max < stones[i])
                max = stones[i];
        return max;
    }
}
