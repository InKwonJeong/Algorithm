package baekjoon.stage.onedimensionalarray;

import java.util.HashSet;
import java.util.Scanner;

public class Remainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            set.add(input.nextInt() % 42);
        }
        System.out.println(set.size());
    }
}
