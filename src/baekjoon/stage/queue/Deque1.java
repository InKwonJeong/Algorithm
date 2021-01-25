package baekjoon.stage.queue;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Deque1 {
    public static void main(String[] args) {
        int N, data;
        String command;

        Scanner input = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();

        N = input.nextInt();
        for (int i = 0; i < N; i++) {
            command = input.next();

            switch (command) {
                case "push_front":
                    data = input.nextInt();
                    deque.offerFirst(data);
                    break;
                case "push_back":
                    data = input.nextInt();
                    deque.offerLast(data);
                    break;
                case "pop_front":
                    if (!deque.isEmpty())
                        System.out.println(deque.pollFirst());
                    else
                        System.out.println("-1");
                    break;
                case "pop_back":
                    if (!deque.isEmpty())
                        System.out.println(deque.pollLast());
                    else
                        System.out.println("-1");
                    break;
                case "front":
                    if (!deque.isEmpty())
                        System.out.println(deque.peekFirst());
                    else
                        System.out.println("-1");
                    break;
                case "back":
                    if (!deque.isEmpty())
                        System.out.println(deque.peekLast());
                    else
                        System.out.println("-1");
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (!deque.isEmpty())
                        System.out.println("0");
                    else
                        System.out.println("1");
                    break;
            }
        }
    }
}

