package baekjoon.stage.string;

import java.util.Scanner;

public class ASCIICode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.next();
        System.out.println((int) a.charAt(0));
    }
}
