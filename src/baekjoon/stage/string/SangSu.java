package baekjoon.stage.string;

import java.util.Scanner;

public class SangSu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder a = new StringBuilder(input.next());
        StringBuilder b = new StringBuilder(input.next());

        a = a.reverse();
        b = b.reverse();

        if(a.toString().compareTo(b.toString()) > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
