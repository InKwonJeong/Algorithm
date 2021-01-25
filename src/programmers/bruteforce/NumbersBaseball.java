package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class NumbersBaseball {
    public static void main(String[] args) {
        int[][] baseball = {
                {123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}
        };
        System.out.println(new NumbersBaseball().solution(baseball));
    }

    private Set<String> nums;
    private boolean[] visit;
    private int[][] baseballs;

    public int solution(int[][] baseballs) {
        this.baseballs = baseballs;
        nums = new HashSet<>();
        visit = new boolean[10];
        int answer = 0;

        permutation(0, "");

        for(String num : nums) {
            if(check(num))
                answer++;
        }

        return answer;
    }

    private boolean check(String num1) {
        for(int[] baseball : baseballs) {
            String num2 = String.valueOf(baseball[0]);
            int strike = 0;
            int ball = 0;
            for(int i = 0; i < num1.length(); i++) {
                if(num1.charAt(i) == num2.charAt(i))
                    strike++;
                else if(num2.contains(String.valueOf(num1.charAt(i))))
                    ball++;
            }
            if(strike != baseball[1] || ball != baseball[2])
                return false;
        }
        return true;
    }

    private void permutation(int depth, String num) {
        if(depth == 3) {
            nums.add(num);
            return;
        }

        for(int i = 1; i < visit.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                permutation(depth + 1, num + i);
                visit[i] = false;
            }
        }
    }
}
