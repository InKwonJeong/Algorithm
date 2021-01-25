package programmers.practice;

import java.util.Stack;

public class CorrectParentheses {
    public static void main(String[] args) {
        String[] S = {
                "()()",
                "(())()",
                ")()(",
                "(()("
        };
        for(String s : S)
            System.out.println(new CorrectParentheses().solution(s));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
