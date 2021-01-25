package baekjoon.implementation;

import java.util.Scanner;

public class Year2007 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = input.nextInt();
        int day = input.nextInt();

        int today = 0;
        for(int i = 1; i < month; i++) {
            today += days[i];
        }
        today += day;
        System.out.println(dayOfWeek[today % 7]);
    }
}
