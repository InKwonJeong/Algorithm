package baekjoon.stage.ifstatement;

import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int minute = input.nextInt();

        if(minute >= 45) {
            System.out.println(hour + " " + (minute - 45));
        } else {
            if(hour != 0) {
                System.out.println((hour - 1) + " " + (minute + 60 - 45));
            } else {
                System.out.println(23 + " " + (minute + 60 - 45));
            }
        }
    }
}
