package programmers.greedy;

public class GymSuit {
    public static void main(String[] args) {
        int[] n = {5, 5, 3};
        int[][] lost = {
                {2, 4},
                {2, 4},
                {3}
        };
        int[][] reserve = {
                {1, 3, 5},
                {3},
                {1}
        };
        for (int i = 0; i < n.length; i++)
            System.out.println(new GymSuit().solution(n[i], lost[i], reserve[i]));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] suits = new int[n + 1];
        for (int i = 1; i <= n; i++)
            suits[i] = 1;

        for (int value : lost) suits[value]--;
        for (int value : reserve) suits[value]++;

        for(int i = 1; i <= n; i++) {
            if(suits[i] == 2) {
                if(i != 1 && suits[i - 1] == 0) {
                    suits[i - 1]++;
                    suits[i]--;
                } else if(i != n && suits[i + 1] == 0) {
                    suits[i + 1]++;
                    suits[i]--;
                }
            }
        }

        for(int value : suits) {
            if(value != 0)
                answer++;
        }

        return answer;
    }
}
