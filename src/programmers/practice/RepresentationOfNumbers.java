package programmers.practice;

public class RepresentationOfNumbers {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(new RepresentationOfNumbers().solution(n));
    }

    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            int total = 0;
            for(int j = i; j <= n; j++) {
                total += j;
                if(total == n)
                    answer++;
                else if(total > n)
                    break;
            }
        }
        return answer;
    }
}
