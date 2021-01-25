package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {1, 2, 3, 4};
        int[] supplies = {10, 40, 20, 30};
        int k = 100;
        System.out.println(new RamenFactory().solution(stock, dates, supplies, k));
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);

            if(stock == 0) {
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}
