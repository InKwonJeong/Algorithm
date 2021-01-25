package baekjoon.stage.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CreatePassword {

    private static int n, m;
    private static String[] alphabet, word;
    private static boolean[] visit;
    private static HashSet<String> vowels;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        word = new String[n];
        alphabet = new String[m];
        visit = new boolean[m];
        vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        for(int i = 0; i < m; i++)
            alphabet[i] = input.next();

        Arrays.sort(alphabet);
        combination(0, 0);
    }

    private static void combination(int start, int depth) {
        if(depth == n) {
            int v = count();
            int w = n - v;
            if(v >= 1 && w >= 2) {
                StringBuilder builder = new StringBuilder();
                for(int i = 0; i < n; i++)
                    builder.append(word[i]);
                System.out.println(builder);
            }
            return;
        }

        for(int i = start; i < m; i++) {
            if(!visit[i]) {
                visit[i] = true;
                word[depth] = alphabet[i];
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int count() {
        int count = 0;
        for(String w : word) {
            if(vowels.contains(w))
                count++;
        }
        return count;
    }
}
