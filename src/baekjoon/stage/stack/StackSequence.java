package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackSequence {

    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        builder = new StringBuilder();
        int n = input.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = input.nextInt();

        boolean finish = true;
        Stack<Integer> stack = new Stack<>();
        int value = 1;
        for(int a : A) {
            if(a > value) {
                while (a >= value) {
                    push(stack, value++);
                }
                pop(stack);
            } else if(a < value) {
                if(stack.peek() == a) {
                    pop(stack);
                } else {
                    finish = false;
                    break;
                }
            } else {
                push(stack, value++);
                pop(stack);
            }
        }


        if(finish)
            System.out.println(builder);
        else
            System.out.println("NO");
    }

    private static void push(Stack<Integer> stack, int value) {
        stack.push(value);
        builder.append("+\n");
    }

    private static void pop(Stack<Integer> stack) {
        stack.pop();
        builder.append("-\n");
    }

}
