package baekjoon.stage.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimeProduct {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        int[] primes = new int[n];
        for(int i = 0; i < n; i++) {
            primes[i] = input.nextInt();
            priorityQueue.offer((long) primes[i]);
        }

        long num = 0;
        while (k --> 0) {
            num = priorityQueue.poll();
            for(int i = 0; i < n; i++) {
                long next = num * primes[i];
                priorityQueue.offer(next);

                if(num % primes[i] == 0)
                    break;
            }
        }
        System.out.println(num);
    }
}
