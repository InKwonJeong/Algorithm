package baekjoon.stage.bisection;

import java.util.HashMap;
import java.util.Scanner;

public class NumberCard2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = input.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = input.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++)
            b[i] = input.nextInt();

        for(int i = 0; i < m; i++) {
            System.out.print(map.getOrDefault(b[i], 0) + " ");
        }
    }
}
