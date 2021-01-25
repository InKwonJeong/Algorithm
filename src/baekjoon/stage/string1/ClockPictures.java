package baekjoon.stage.string1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ClockPictures {

    private static final int MAX = 360000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] a = new char[MAX];
        char[] b = new char[MAX];

        Arrays.fill(a, '0');
        Arrays.fill(b, '0');

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            a[index] = '1';
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            b[index] = '1';
        }

        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);

        if(shift(s1, s2) == 0)
            System.out.println("impossible");
        else
            System.out.println("possible");
    }

    private static int shift(String text, String pattern) {
        String doubleText = text + text.substring(0, text.length() - 1);
        return kmp(doubleText, pattern).size();
    }

    private static int[] pi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if(pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }
        return pi;
    }

    private static List<Integer> kmp(String text, String pattern) {
        List<Integer> result = new LinkedList<>();
        int[] pi = pi(pattern);
        int j = 0;
        for(int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if(text.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    result.add(i + j - 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
