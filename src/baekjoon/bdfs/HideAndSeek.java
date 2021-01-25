package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        if (n > k)
            System.out.println(n - k);
        else if (n == k)
            System.out.println(0);
        else {
            Queue<Point> queue = new LinkedList<>();
            boolean[] check = new boolean[100001];

            queue.offer(new Point(n, 0));
            check[n] = true;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int time = point.time;
                if (x == k) {
                    System.out.println(time);
                    break;
                }

                if (x - 1 >= 0 && !check[x - 1]) {
                    queue.offer(new Point(x - 1, time + 1));
                    check[x - 1] = true;
                }
                if (x + 1 <= 100000 && !check[x + 1]) {
                    queue.offer(new Point(x + 1, time + 1));
                    check[x + 1] = true;
                }
                if (x * 2 <= 100000 && !check[x * 2]) {
                    queue.offer(new Point(x * 2, time + 1));
                    check[x * 2] = true;
                }
            }
        }
    }

    static class Point {
        int x;
        int time;

        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
