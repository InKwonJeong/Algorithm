package baekjoon.stage.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (n > 0) {
            int num = input.nextInt();
            if(num == 0) {
                if(priorityQueue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(priorityQueue.poll());
            } else
                priorityQueue.add(num);

            n--;
        }
    }
}
