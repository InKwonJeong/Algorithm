package programmers.summerwintercoding2;

import java.util.Arrays;

public class Origami {
    public static void main(String[] args) {
        int[] N = {1, 2, 3};
        for(int n : N)
            System.out.println(Arrays.toString(new Origami().solution(n)));
    }

    public int[] solution(int n) {
        String[] d = new String[n + 1];
        d[1] = "0";

        for(int i = 2; i <= n; i++)
            d[i] = d[i - 1] + "0" + reverse(d[i - 1]);

        int[] answer = new int[d[n].length()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = d[n].charAt(i) - '0';

        return answer;
    }

    private String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c == '0')
                builder.append('1');
            else
                builder.append('0');
        }
        return builder.reverse().toString();
    }
}
