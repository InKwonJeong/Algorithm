package programmers.kakao2;

import java.util.Stack;

public class ParenthesisConversion {
    public static void main(String[] args) {
        String[] s = {
                "(()())()",
                ")(",
                "()))((()",
                ")()()()(",
                ""
        };
        for (String p : s)
            System.out.println(new ParenthesisConversion().solution(p));
    }

    public String solution(String p) {
        return divide(p);
    }

    private String divide(String p) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                count++;
            else
                count--;

            if(count == 0) {
                String u = p.substring(0, i + 1);
                String v = p.substring(i + 1);
                if(check(u)) {
                    builder.append(u);
                    builder.append(divide(v));
                } else {
                    builder.append('(');
                    builder.append(divide(v));
                    builder.append(')');
                    for(int j = 1; j < u.length() - 1; j++) {
                        if(u.charAt(j) == '(')
                            builder.append(')');
                        else
                            builder.append('(');
                    }
                }
                break;
            }
        }
        return builder.toString();
    }

    private boolean check(String u) {
        Stack<Character> stack = new Stack<>();
        for(char c : u.toCharArray()) {
            if(c == '(')
                stack.push(c);
            else {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
