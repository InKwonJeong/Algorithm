package baekjoon.implementation;

import java.util.Scanner;

public class TestScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] minkuk = new int[4];
        int[] manse = new int[4];

        for(int i = 0; i < 4; i++) {
            minkuk[i] = input.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            manse[i] = input.nextInt();
        }

        int total_minkuk = 0;
        int total_manse = 0;
        for(int i = 0; i < 4; i++) {
            total_minkuk += minkuk[i];
            total_manse += manse[i];
        }

        if(total_minkuk < total_manse)
            System.out.println(total_manse);
        else
            System.out.println(total_minkuk);
    }
}
