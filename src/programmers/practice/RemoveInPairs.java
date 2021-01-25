package programmers.practice;

import java.util.Stack;

public class RemoveInPairs {
    public static void main(String[] args) {
        String[] S = {
                "baabaa",
                "cdcd"
        };
        for(String s : S)
            System.out.println(new RemoveInPairs().solution(s));
    }

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
