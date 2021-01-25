package codingtest.kakao;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        String[] expressions = {
                "100-200*300-500+20",
                "50*6-3*2"
        };
        for(String expression : expressions) {
            System.out.println(new Problem2().solution(expression));
        }
    }

    private String experssion;
    private long answer;
    private long[] numbers;
    private String[] operators, chosen_operators;
    private boolean[] visit;
    private HashMap<String, Integer> priorities;

    public long solution(String expression) {
        this.experssion = expression;
        priorities = new HashMap<>();

        Matcher operator_matcher = Pattern.compile("[+\\-*]").matcher(expression);
        HashSet<String> operators_set = new HashSet<>();
        while (operator_matcher.find())
            operators_set.add(operator_matcher.group());

        String[] numbers_string = expression.split("[+\\-*]");

        operators = new String[operators_set.size()];
        operators_set.toArray(operators);

        numbers = new long[numbers_string.length];
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = Long.parseLong(numbers_string[i]);

        chosen_operators = new String[operators.length];
        visit = new boolean[operators.length];

        permutation(0);

        return answer;
    }

    private void permutation(int depth) {
        if(depth == chosen_operators.length) {
            for (int i = 0; i < chosen_operators.length; i++)
                priorities.put(chosen_operators[i], i);

            long result = calculate();
            if(result > answer)
                answer = result;
            return;
        }

        for(int i = 0; i < operators.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                chosen_operators[depth] = operators[i];
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }

    private long calculate() {
        Stack<Long> number_stack = new Stack<>();
        Stack<String> operator_stack = new Stack<>();

        Matcher matcher = Pattern.compile("[0-9]+|[+\\-*]").matcher(experssion);
        List<String> list = new ArrayList<>();
        while (matcher.find())
            list.add(matcher.group());

        for(String str : list) {
            if(str.matches("[0-9]+")) {
                number_stack.push(Long.parseLong(str));
            } else {
                if(!operator_stack.isEmpty()) {
                    int prev_priority = priorities.get(operator_stack.peek());
                    int now_prioirty = priorities.get(str);
                    while (prev_priority >= now_prioirty) {
                        long b = number_stack.pop();
                        long a = number_stack.pop();
                        String operator = operator_stack.pop();
                        number_stack.push(calculate(a, b, operator));
                        if(operator_stack.isEmpty())
                            break;
                        prev_priority = priorities.get(operator_stack.peek());
                    }
                }
                operator_stack.push(str);
            }
        }

        while (!operator_stack.isEmpty()) {
            long b = number_stack.pop();
            long a = number_stack.pop();
            String operator = operator_stack.pop();
            number_stack.push(calculate(a, b, operator));
        }

        return Math.abs(number_stack.pop());
    }

    private long calculate(long a, long b, String operator) {
        if(operator.equals("+")) {
            return a + b;
        } else if(operator.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }
}
