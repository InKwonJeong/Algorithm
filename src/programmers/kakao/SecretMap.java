package programmers.kakao;

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
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            String str1 = makeBinary(arr1[i]);
            String str2 = makeBinary(arr2[i]);
            for(int j = 0; j < n; j++) {
                if(str1.charAt(j) == '0' && str2.charAt(j) == '0')
                    builder.append(" ");
                else
                    builder.append("#");
            }
            answer[i] = builder.toString();
        }


        return answer;
    }

    private String makeBinary(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(num % 2);
            num /= 2;
        }
        for(int i = builder.length(); i < n; i++)
            builder.append(0);
        builder.reverse();
        return builder.toString();
    }
}
