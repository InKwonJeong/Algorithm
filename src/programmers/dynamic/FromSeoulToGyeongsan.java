package programmers.dynamic;

public class FromSeoulToGyeongsan {
    public static void main(String[] args) {
        int[] K = {1650, 3000};
        int[][][] travel = {
                {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}},
                {{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}}
        };
        for(int i = 0; i < K.length; i++)
            System.out.println(new FromSeoulToGyeongsan().solution(K[i], travel[i]));
    }

    public int solution(int K, int[][] travel) {
        int length = travel.length;
        int[][] dp = new int[length][K + 1];
        int answer = 0;
        dp[0][travel[0][0]] = travel[0][1];
        dp[0][travel[0][2]] = travel[0][3];

        for (int i = 1; i < length; i++) {
            for (int k = 0; k <= K; k++) {
                if (dp[i - 1][k] == 0) {
                    continue;
                }

                if (k + travel[i][0] <= K) { // walk
                    dp[i][k + travel[i][0]] = Math.max(dp[i][k + travel[i][0]], dp[i - 1][k] + travel[i][1]);
                    answer = Math.max(answer, dp[i][k + travel[i][0]]);
                }

                if (k + travel[i][2] <= K) { // bike
                    dp[i][k + travel[i][2]] = Math.max(dp[i][k + travel[i][2]], dp[i - 1][k] + travel[i][3]);
                    answer = Math.max(answer, dp[i][k + travel[i][2]]);
                }
            }
        }

        return answer;
    }
}
