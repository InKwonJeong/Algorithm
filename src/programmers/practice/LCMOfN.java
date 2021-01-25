package programmers.practice;

public class LCMOfN {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 6, 8, 14},
                {1, 2, 3}
        };
        for(int[] a : arr)
            System.out.println(new LCMOfN().solution(a));
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gcd;
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if(a > b) {
            if(a % b == 0)
                return b;
            else
                return gcd(b, a % b);
        } else if(a < b) {
            if(b % a == 0)
                return a;
            else
                return gcd(a, b % a);
        } else
            return a;
    }
}
