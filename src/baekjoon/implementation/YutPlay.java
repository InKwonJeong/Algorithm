package baekjoon.implementation;

import java.util.Scanner;

public class YutPlay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] yut = {'E', 'A', 'B', 'C', 'D'};
        for(int i = 0; i < 3; i++) {
            int count = 0;
            for(int j = 0; j < 4; j++) {
                if(input.nextInt() == 0)
                    count++;
            }
            System.out.println(yut[count]);
        }
    }
}
