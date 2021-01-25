package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int num = input.nextInt();
            if(num == 0)
                stack.pop();
            else
                stack.push(num);
            n--;
        }

        int answer = 0;
        while (!stack.isEmpty())
            answer += stack.pop();

        System.out.println(answer);
    }
}
