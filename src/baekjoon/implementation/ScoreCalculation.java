package baekjoon.implementation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Quiz[] d = new Quiz[8];
        Quiz[] answer = new Quiz[5];
        for(int i = 0; i < 8; i++) {
            int point = input.nextInt();
            d[i] = new Quiz(i + 1, point);
        }

        Arrays.sort(d, (o1, o2) -> Integer.compare(o2.point, o1.point));

        int total = 0;
        for(int i = 0 ; i < 5; i++) {
            answer[i] = d[i];
            total += d[i].point;
        }

        Arrays.sort(answer, Comparator.comparingInt(o -> o.stage));

        System.out.println(total);
        for(int i = 0; i < 5; i ++) {
            System.out.printf("%d ", answer[i].stage);
        }
    }

    static class Quiz {
        int stage, point;

        Quiz(int stage, int point) {
            this.stage = stage;
            this.point = point;
        }
    }
}
