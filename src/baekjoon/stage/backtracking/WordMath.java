package baekjoon.stage.backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class WordMath {

    private static int n, max;
    private static boolean[] visit;
    private static String[] words;
    private static int[] values;
    private static HashMap<Character, Integer> letters;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        visit = new boolean[10];
        words = new String[n];
        letters = new HashMap<>();

        int index = 0;
        for(int i = 0; i < n; i++) {
            words[i] = input.next();
            for(char c : words[i].toCharArray()) {
                if(!letters.containsKey(c))
                    letters.put(c, index++);
            }
        }
        values = new int[letters.size()];

        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if(depth == values.length) {
            int sum = calculate();
            if(sum > max)
                max = sum;
            return;
        }

        for(int i = 9; i >= 0; i--) {
            if(!visit[i]) {
                visit[i] = true;
                values[depth] = i;
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int calculate() {
        int sum = 0;
        for(String word: words) {
            int value = 0;
            for(char c : word.toCharArray()) {
                int index = letters.get(c);
                value *= 10;
                value += values[index];
            }
            sum += value;
        }
        return sum;
    }
}
