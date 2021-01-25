package programmers.stackandqueue;

import java.util.Stack;

public class IronBar {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        System.out.println(new IronBar().solution(arrangement));
    }

    public int solution(String arrangement) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char prev = ' ';
        for(int i = 0; i < arrangement.length(); i++) {
            char c = arrangement.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if(prev == '(')
                    answer += stack.size();
                else if(prev == ')')
                    answer++;
            }
            prev = c;
        }

        return answer;
    }
}
