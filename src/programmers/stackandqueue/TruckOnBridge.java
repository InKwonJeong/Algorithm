package programmers.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnBridge {
    public static void main(String[] args) {
        int[] bridge_length = {2, 100, 100};
        int[] weight = {10, 100, 100};
        int[][] truck_weights = {
                {7, 4, 5, 6},
                {10},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        };
        for(int i = 0; i < bridge_length.length; i++)
            System.out.println(new TruckOnBridge().solution(bridge_length[i], weight[i], truck_weights[i]));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++)
            queue.offer(null);

        int answer = 0;
        int index = 0;
        int truck_weight = 0;
        while (!queue.isEmpty()) {
            Integer truck = queue.poll();
            answer++;

            if(index == truck_weights.length)
                continue;

            if(truck != null)
                truck_weight -= truck;

            if(weight >= truck_weight + truck_weights[index]) {
                queue.add(truck_weights[index]);
                truck_weight += truck_weights[index];
                index++;
            } else
                queue.add(null);
        }

        return answer;
    }
}
