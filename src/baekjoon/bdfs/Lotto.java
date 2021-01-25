package baekjoon.bdfs;

import java.util.Scanner;

public class Lotto {

    private static int n;
    private static int[] d;
    private static int[] a;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            n = input.nextInt();
            if(n == 0)
                break;

            a = new int[6];
            check = new boolean[n];
            d = new int[n];
            for(int i = 0; i < n; i++) {
                d[i] = input.nextInt();
            }
            bfs(0, 0);
            System.out.println();
        }
    }

    static void bfs(int start, int count) {
        if(count == 6) {
            for(int i : a)
                System.out.printf("%d ", i);
            System.out.println();
            return;
        }
        for(int i = start; i < n; i++) {
            if(!check[i]) {
                a[count] = d[i];
                check[i] = true;
                bfs(i + 1, count + 1);
                check[i] = false;
            }
        }
    }
}
