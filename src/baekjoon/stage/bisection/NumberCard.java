package baekjoon.stage.bisection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] card_number = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            card_number[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] check_number = new int[m];
        int[] answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            check_number[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(card_number);
        for (int i = 0; i < check_number.length; i++) {
            if (contains(card_number, check_number[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }

        for (int a : answer)
            System.out.printf("%d ", a);
    }

    private static boolean contains(int[] card_number, int number) {
        int start = 0;
        int end = card_number.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(number == card_number[mid])
                return true;
            else if(number > card_number[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
