package baekjoon.stage.stack;

import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        int T;
        String vps;

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        T = input.nextInt();
        for (int i = 0; i < T; i++) {
            vps = input.next();
            for (int j = 0; j < vps.length(); j++) {
                if (vps.charAt(j) == '(')
                    stack.push(vps.charAt(j));
                else {
                    if (!stack.empty())
                        stack.pop();
                    else {
                        stack.push(vps.charAt(j));
                        break;
                    }
                }
            }
            if (stack.empty())
                System.out.println("YES");
            else
                System.out.println("NO");

            stack.clear();
        }
    }
}

