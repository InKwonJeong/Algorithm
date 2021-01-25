package programmers.kakao2;

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

    private char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int order = p;
        for(int i = 0; i < t; i++) {
            answer.append(number(n, order));
            order += m;
        }

        return answer.toString();
    }

    private char number(int n, int order) {
        if(order == 1)
            return '0';

        order--;
        int digit = 1;
        int num = n - 1;
        while (true) {
            if(order > num * digit)
                order -= num * digit;
            else
                break;

            digit++;
            num *= n;
        }

        int number = (order - 1) / digit + (int) Math.pow(n, digit - 1);
        int index = (order - 1) % digit;
        return convert(n, number).charAt(index);
    }

    private String convert(int n, int number) {
        StringBuilder builder = new StringBuilder();
        while (number > 0) {
            builder.append(nums[number % n]);
            number /= n;
        }
        return builder.reverse().toString();
    }
}
