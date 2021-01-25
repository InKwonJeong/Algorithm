package baekjoon.stage.brueforce;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs {

    private static int[] dwarfs, choice;
    private static boolean[] visit;
    private static boolean finish;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dwarfs = new int[9];
        choice = new int[7];
        visit = new boolean[9];

        for(int i = 0; i < 9; i++)
            dwarfs[i] = input.nextInt();

        combination(0, 0);
    }

    private static void combination(int start, int depth) {
        if(finish)
            return;

        if(depth == 7) {
            int total = 0;
            for(int c : choice)
                total += c;

            if(total == 100) {
                Arrays.sort(choice);
                for(int c : choice)
                    System.out.println(c);

                finish = true;
            }
            return;
        }

        for(int i = start; i < 9; i++) {
            if(!visit[i]) {
                visit[i] = true;
                choice[depth] = dwarfs[i];
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
