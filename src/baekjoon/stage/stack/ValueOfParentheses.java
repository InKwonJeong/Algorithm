package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValueOfParentheses {

    private static char[] str;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        str = input.next().toCharArray();

        if(check())
            System.out.println(calculate(0, str.length - 1));
        else
            System.out.println(0);
    }

    private static boolean check() {
        Stack<Character> stack = new Stack<>();
        for(char c : str) {
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static int calculate(int start, int end) {
        if(start < end) {
            int sum = 0;
            int count = 0;
            for (int i = start; i <= end; i++) {
                if (str[i] == '(' || str[i] == '[') {
                    count++;
                } else {
                    count--;
                }

                if (count == 0) {
                    if (str[i] == ')') {
                        sum += 2 * calculate(start + 1, i - 1);
                    } else {
                        sum += 3 * calculate(start + 1, i - 1);
                    }
                    start = i + 1;
                }
            }

            return sum;
        } else {
            return 1;
        }
    }
}
