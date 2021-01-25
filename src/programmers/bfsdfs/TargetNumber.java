package programmers.bfsdfs;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2};
        int target = 3;
        System.out.println(new TargetNumber().solution(numbers, target));
    }

    private int n, answer, target, total;
    private int[] numbers;
    private boolean[] visit;

    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        visit = new boolean[numbers.length];

        for(int number : numbers)
            total += number;

        for(int i = 1; i <= numbers.length; i++) {
            n = i;
            dfs(0, 0, total);
        }

        return answer;
    }

    private void dfs(int start, int depth, int number) {
        if(depth == n) {
            if(number == target)
                answer++;
            return;
        }

        if(number <= target)
            return;


        for(int i = start; i < numbers.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1, number - numbers[i] * 2);
                visit[i] = false;
            }
        }
    }
}
