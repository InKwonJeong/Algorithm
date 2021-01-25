package programmers.kakao;

public class NNotationGame {
    public static void main(String[] args) {
        int[] n = {2, 16, 16};
        int[] t = {4, 16, 16};
        int[] m = {2, 2, 2};
        int[] p = {1, 1, 2};
        for(int i = 0; i < n.length; i++) {
            System.out.println(new NNotationGame().solution(n[i], t[i], m[i], p[i]));
        }
    }

    private int n;
    char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        this.n = n;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int index = p + i * m;
            int digit = 1;
            int limit = n;

            while (index > limit) {
                index -= limit;
                digit++;
                limit = digit * (int) (Math.pow(n, digit) - Math.pow(n, digit - 1));
            }

            int q = (int) Math.ceil((double) index / digit) - 1;
            int r = (index - 1) % digit;

            int num = q;
            if(digit != 1)
                num += (int) Math.pow(n, digit - 1);

            builder.append(getChar(num, r));
        }

        return builder.toString();
    }

    private char getChar(int num, int r) {
        if(num == 0)
            return '0';

        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(nums[num % n]);
            num /= n;
        }
        builder.reverse();
        return builder.toString().charAt(r);
    }
}
