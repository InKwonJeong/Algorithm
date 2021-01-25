package baekjoon.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LongestIncreasingPartialSequence5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        int n = input.nextInt();
        int[] d = new int[n];
        int[] a = new int[n];
        int[] indexes = new int[n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            a[i] = input.nextInt();

        list.add(a[0]);
        indexes[0] = 0;
        for(int i = 1; i < n; i++) {
            if(list.get(list.size() - 1) < a[i]) {
                list.add(a[i]);
                indexes[i] = list.size() - 1;
            } else {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if(list.get(mid) >= a[i]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(end, a[i]);
                indexes[i] = end;
            }
        }

        builder.append(list.size()).append("\n");
        Stack<Integer> stack = new Stack<>();
        int index = list.size() - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(indexes[i] == index) {
                stack.push(a[i]);
                index--;
            }
        }

        while (!stack.isEmpty())
            builder.append(stack.pop()).append(" ");

        System.out.println(builder);
    }
}
