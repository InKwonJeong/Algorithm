package baekjoon.stage.queue;

import java.util.*;

public class JosephusProblem0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = input.nextInt();
        int k = input.nextInt();
        for(int i = 1; i <= n; i++)
            queue.offer(i);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for(int i = 1; i < k; i++)
                queue.offer(queue.poll());

            list.add(queue.poll());
        }

        System.out.print("<");
        for(int i = 0; i < n; i++) {
            System.out.print(list.get(i));
            if(i != n - 1)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}
