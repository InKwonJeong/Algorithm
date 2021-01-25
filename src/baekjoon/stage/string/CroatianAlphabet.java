package baekjoon.stage.string;

import java.util.Scanner;

public class CroatianAlphabet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next()
                .replace("c=", "*")
                .replace("c-", "*")
                .replace("dz=", "*")
                .replace("d-", "*")
                .replace("lj", "*")
                .replace("nj", "*")
                .replace("s=", "*")
                .replace("z=", "*");

        System.out.println(s.length());
    }
}
