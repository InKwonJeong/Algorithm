package baekjoon.greedy;

import java.util.Scanner;

public class StandInOneLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] line = new int[n];

        for(int i = 1; i <= n; i++) {
            int tall = input.nextInt();
            int count = 0;
            int index = 0;
            while(count != tall) {
                if(line[index++] == 0)
                    count++;
            }
            if(line[index] == 0)
                line[index] = i;
            else {
                while(true) {
                    if(line[++index] == 0) {
                        line[index] = i;
                        break;
                    }
                }
            }
        }

        for(int person : line)
            System.out.printf("%d ", person);
    }
}
