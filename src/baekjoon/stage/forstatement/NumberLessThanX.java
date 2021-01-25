package baekjoon.stage.forstatement;

import java.util.Scanner;

public class NumberLessThanX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int x = input.nextInt();
        for(int i = 0; i < n; i++) {
            int num = input.nextInt();
            if(num < x)
                System.out.printf("%d ", num);
        }
    }
}
