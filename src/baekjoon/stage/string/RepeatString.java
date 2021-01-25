package baekjoon.stage.string;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            String s = input.next();
            for(char c : s.toCharArray()) {
                for(int i = 0; i < n; i++)
                    System.out.print(c);
            }
            System.out.println();
            t--;
        }
    }
}
