package baekjoon.stage.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            String command = input.next();
            boolean error = false;
            int n = input.nextInt();
            String[] nums = input.next()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < n; i++)
                deque.add(Integer.parseInt(nums[i]));

            boolean reverse = false;
            for(char c : command.toCharArray()) {
                if(c == 'R') {
                    reverse = !reverse;
                } else {
                    if(deque.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if(reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if(error)
                System.out.println("error");
            else {
                System.out.print("[");
                if(reverse) {
                    while (!deque.isEmpty()) {
                        System.out.print(deque.removeLast());
                        if(!deque.isEmpty())
                            System.out.print(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        System.out.print(deque.removeFirst());
                        if(!deque.isEmpty())
                            System.out.print(",");
                    }
                }
                System.out.println("]");
            }

            t--;
        }
    }
}
