package programmers.practice;

public class NextBigNumber {
    public static void main(String[] args) {
        int[] N = {78, 15};
        for(int n : N)
            System.out.println(new NextBigNumber().solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        int count = count(n);
        while (true) {
            n++;
            if(count == count(n)) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    private int count(int n) {
        int count = 0;
        while (n > 0) {
            if(n % 2 == 1)
                count++;

            n /= 2;
        }
        return count;
    }
}
