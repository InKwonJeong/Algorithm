package programmers.kakao2;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int[] n = {5, 6};
        int[][] arr1 = {
                {9, 20, 28, 18, 11},
                {46, 33, 33, 22, 31, 50}
        };
        int[][] arr2 = {
                {30, 1, 21, 17, 28},
                {27, 56, 19, 14, 14, 10}
        };
        for(int i = 0; i < n.length; i++)
            System.out.println(Arrays.toString(new SecretMap().solution(n[i], arr1[i], arr2[i])));
    }

    private int n;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        this.n = n;
        String[] answer = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++) {
            StringBuilder builder = new StringBuilder();
            String s1 = convert(arr1[i]);
            String s2 = convert(arr2[i]);
            for(int j = 0; j < n; j++) {
                if(s1.charAt(j) == ' ' && s2.charAt(j) == ' ')
                    builder.append(' ');
                else
                    builder.append('#');
            }
            answer[i] = builder.toString();
        }
        return answer;
    }

    private String convert(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if(num % 2 == 0)
                builder.append(' ');
            else
                builder.append('#');
            num /= 2;
        }

        while (builder.length() < n)
            builder.append(' ');

        return builder.reverse().toString();
    }
}
