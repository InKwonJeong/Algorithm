package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        int N, data;
        String command;

        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        N = input.nextInt();
        for(int i=0;i<N;i++) {
            command = input.next();

            switch(command) {
                case "push":
                    data = input.nextInt();
                    stack.push(data);
                    break;
                case "pop":
                    if(!stack.empty())
                        System.out.println(stack.pop());
                    else
                        System.out.println("-1");
                    break;
                case "top":
                    if(!stack.empty())
                        System.out.println(stack.peek());
                    else
                        System.out.println("-1");
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(!stack.empty())
                        System.out.println("0");
                    else
                        System.out.println("1");
                    break;
            }
        }
    }
}

