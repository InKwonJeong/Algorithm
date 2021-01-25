package baekjoon.implementation;

import java.util.Scanner;

public class Funghi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] mushrooms = new int[8];
        int[] answers = new int[8];

        for(int i = 0; i < 8; i++) {
            mushrooms[i] = input.nextInt();
        }

        for(int i = 0; i < 8; i++) {
            answers[i] =
                    mushrooms[i%8] + mushrooms[(i+1)%8] + mushrooms[(i+2)%8] + mushrooms[(i+3)%8];
        }

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            if(answer < answers[i])
                answer = answers[i];
        }

        System.out.println(answer);
    }
}
