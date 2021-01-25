package baekjoon.stage.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            tower[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        stack.push(tower[0]);
        index.push(1);
        tower[0] = 0;

        for(int i = 1; i < n; i++) {
            int height = tower[i];
            while (!stack.isEmpty() && stack.peek() < height) {
                stack.pop();
                index.pop();
            }

            if(stack.isEmpty()) {
                tower[i] = 0;
            } else {
                tower[i] = index.peek();
            }

            stack.push(height);
            index.push(i + 1);
        }

        for(int a : tower)
            builder.append(a).append(" ");

        System.out.println(builder);
    }
}
