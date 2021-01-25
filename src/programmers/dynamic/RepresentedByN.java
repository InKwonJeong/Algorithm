package programmers.dynamic;

public class RepresentedByN {
    public static void main(String[] args) {
        int[] N = {5, 5};
        int[] number = {12, 31168};
        for(int i = 0; i < N.length; i++)
            System.out.println(new RepresentedByN().solution(N[i], number[i]));
    }

    private int N, number, answer;

    public int solution(int N, int number) {
        this.number = number;
        this.N = N;
        answer = -1;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int count, int prev) {
        if(count > 8)
            return;

        if(prev == number) {
            if(answer == -1 || answer > count)
                answer = count;
            return;
        }

        int n = N;
        for(int i = 0; i < 8 - count; i++) {
            dfs(count + i + 1, prev + n);
            dfs(count + i + 1, prev - n);
            dfs(count + i + 1, prev * n);
            dfs(count + i + 1, prev / n);
            n = n * 10 + N;
        }
    }
}
