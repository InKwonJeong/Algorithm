package baekjoon.stage.string;

import java.util.Scanner;

public class NumberOfWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] S = input.nextLine().trim().split(" ");
        int answer = 0;
        for(String s : S) {
            if(!s.equals(""))
                answer++;
        }
        System.out.println(answer);
    }
}
