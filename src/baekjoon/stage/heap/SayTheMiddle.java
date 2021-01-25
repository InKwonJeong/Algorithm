package baekjoon.stage.heap;

import java.util.*;

public class SayTheMiddle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        while (n > 0) {
            int num = input.nextInt();
            max.add(num);
            if((max.size() + min.size()) % 2 != 0) {
                min.add(max.poll());
            } else if(min.peek() > num) {
                max.add(min.poll());
                min.add(max.poll());
            }
            System.out.println(min.peek());

            n--;
        }
    }
}
