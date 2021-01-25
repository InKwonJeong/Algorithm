package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(new MoreSpicy().solution(scoville, k));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int s : scoville)
            queue.add(s);

        int answer = 0;
        while (!queue.isEmpty()) {
            int s1 = queue.poll();
            if(s1 < K) {
                if(queue.isEmpty())
                    return -1;
                int s2 = queue.poll();
                int s = s1 + 2 * s2;
                queue.add(s);
                answer++;
            } else
                break;
        }

        return answer;
    }
}
