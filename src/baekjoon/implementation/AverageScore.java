package baekjoon.implementation;

import java.util.Scanner;

public class AverageScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        for(int i = 0; i < 5; i++) {
            int grade = input.nextInt();
            if(grade < 40)
                total += 40;
            else
                total += grade;
        }
        System.out.println(total / 5);
    }
}
