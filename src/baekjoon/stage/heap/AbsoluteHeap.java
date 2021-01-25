package baekjoon.stage.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AbsoluteHeap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(((o1, o2) -> {
                    if(Math.abs(o1) > Math.abs(o2))
                        return 1;
                    else if(Math.abs(o1) < Math.abs(o2))
                        return -1;
                    else
                        return Integer.compare(o1, o2);
                }));

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
