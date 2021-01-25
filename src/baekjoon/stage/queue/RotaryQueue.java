package baekjoon.stage.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RotaryQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[m];

        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);

        for(int i = 0; i < m; i++)
            nums[i] = input.nextInt();

        int answer = 0;
        int start = 0;
        for(int num : nums) {
            int index = list.indexOf(num);
            int right, left;
            if(start < index) {
                right = index - start;
                left = (list.size() + start) - index;
            } else {
                right = (list.size() + index) - start;
                left = start - index;
            }

            list.remove(index);
            if(left < right) {
                answer += left;
            } else {
                answer += right;
            }

            if(!list.isEmpty())
                start = index % list.size();
        }

        System.out.println(answer);
    }
}
