package baekjoon.stage.math1;

import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] d = new int[5001];
        d[1] = -1;
        d[2] = -1;
        d[3] = 1;
        d[4] = -1;
        d[5] = 1;
        for(int i = 6; i <= n; i++) {
            if(d[i - 3] == -1 && d[i - 5] == -1)
                d[i] = -1;
            else if(d[i - 3] == -1)
                d[i] = 1 + d[i - 5];
            else if(d[i - 5] == -1)
                d[i] = 1 + d[i - 3];
            else
                d[i] = 1 + Math.min(d[i - 3], d[i - 5]);
        }

        System.out.println(d[n]);
    }

}
