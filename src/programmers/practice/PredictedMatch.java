package programmers.practice;

public class PredictedMatch {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(new PredictedMatch().solution(n, a, b));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;

        a--;
        b--;
        while (true) {
            if(a / 2 == b / 2) {
                break;
            } else {
                answer++;
                a /= 2;
                b /= 2;
            }
        }

        return answer;
    }
}
