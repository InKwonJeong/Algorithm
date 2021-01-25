package programmers.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OvertimeIndex {
    public static void main(String[] args) {
        int[] n = {4, 1, 3};
        int[][] works = {
                {4, 3, 3},
                {2, 1, 2},
                {1, 1}
        };
        for(int i = 0; i < n.length; i++)
            System.out.println(new OvertimeIndex().solution(n[i], works[i]));
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int work : works)
            priorityQueue.offer(work);

        for(int i = 0; i < n; i++) {
            if(priorityQueue.isEmpty())
                break;

            int work = priorityQueue.poll();
            work--;
            if(work != 0)
                priorityQueue.offer(work);
        }

        while (!priorityQueue.isEmpty()) {
            int work = priorityQueue.poll();
            answer += work * work;
        }

        return answer;
    }
}
