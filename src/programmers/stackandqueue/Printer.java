package programmers.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[][] priorities = {
                {2, 1, 3, 2},
                {1, 1, 9, 1, 1, 1}
        };
        int[] location = {2, 0};
        for(int i = 0; i < priorities.length; i++)
            System.out.println(new Printer().solution(priorities[i], location[i]));
    }

    public int solution(int[] priorities, int location) {
        Queue<Print> queue = new LinkedList<>();
        int index = 0;
        for(int priority : priorities)
            queue.add(new Print(index++, priority));

        Arrays.sort(priorities);

        int answer = 0;
        int count = 0;
        index = priorities.length - 1;

        while (!queue.isEmpty()) {
            Print print = queue.poll();
            if(priorities[index] == print.priority) {
                count++;
                index--;
                if(print.index == location) {
                    answer = count;
                    break;
                }
            } else {
                queue.add(print);
            }
        }

        return answer;
    }

    static class Print {
        int index, priority;

        public Print(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
