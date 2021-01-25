package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String line = input.nextLine();
            if(line.equals("."))
                break;

            boolean finish = true;
            Stack<Character> stack = new Stack<>();
            for(char c : line.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        finish = false;
                        break;
                    }
                } else if(c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        finish = false;
                        break;
                    }
                }
            }

            if(finish && stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
