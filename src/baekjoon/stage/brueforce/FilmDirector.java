package baekjoon.stage.brueforce;

import java.util.Scanner;

public class FilmDirector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        int a = 666;
        while (true) {
            String s = String.valueOf(a);
            if(s.contains("666"))
                count++;

            if(count == n) {
                System.out.println(a);
                break;
            }
            a++;
        }
    }
}
