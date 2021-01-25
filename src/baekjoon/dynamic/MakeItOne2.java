package baekjoon.dynamic;

import java.util.*;

public class MakeItOne2 {

    private static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] d = new int[n + 1];

        Arrays.fill(d, INF);
        d[n] = 0;

        for (int i = n; i >= 1; i--) {
            int min = d[i] + 1;
            if (i % 3 == 0) d[i / 3] = Math.min(d[i / 3], min);
            if (i % 2 == 0) d[i / 2] = Math.min(d[i / 2], min);
            d[i - 1] = Math.min(d[i - 1], min);
        }

        Stack<Integer> stack = new Stack<>();
        int min = d[1];
        int index = 1;

        while (index <= n) {
            if(min == d[index]) {
                stack.push(index);

                if(index * 3 <= n && d[index * 3] == min - 1)
                    index *= 3;
                else if(index * 2 <= n && d[index * 2] == min - 1)
                    index *= 2;
                else
                    index++;

                min--;
            } else
                index++;
        }

        System.out.println(d[1]);
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

}
