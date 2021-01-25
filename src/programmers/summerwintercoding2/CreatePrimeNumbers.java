package programmers.summerwintercoding2;

public class CreatePrimeNumbers {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {1, 2, 7, 6, 4}
        };
        for(int[] num : nums)
            System.out.println(new CreatePrimeNumbers().solution(num));
    }

    private int answer;
    private int[] nums;
    private boolean[] visit;

    public int solution(int[] nums) {
        this.nums = nums;
        visit = new boolean[nums.length];
        combination(0, 0, 0);

        return answer;
    }

    private void combination(int start, int depth, int num) {
        if(depth == 3) {
            if(isPrimeNumber(num))
                answer++;
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1, num + nums[i]);
                visit[i] = false;
            }
        }
    }

    private boolean isPrimeNumber(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
