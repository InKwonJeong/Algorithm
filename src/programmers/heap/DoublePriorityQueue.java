package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[][] operations = {
                {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"},
                {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
        };
        for(String[] operation : operations)
            System.out.println(Arrays.toString(new DoublePriorityQueue().solution(operation)));
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascent_queue = new PriorityQueue<>();
        PriorityQueue<Integer> descent_queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(String operation : operations) {
            String[] str = operation.split(" ");
            int num = Integer.parseInt(str[1]);
            if(str[0].equals("I")) {
                ascent_queue.add(num);
                descent_queue.add(num);
            } else {
                if(!ascent_queue.isEmpty()) {
                    if (num == -1) {
                        int min = ascent_queue.remove();
                        descent_queue.remove(min);
                    } else {
                        int max = descent_queue.remove();
                        ascent_queue.remove(max);
                    }
                }
            }
        }

        int[] answer = new int[2];
        if(!ascent_queue.isEmpty()) {
            answer[0] = descent_queue.remove();
            answer[1] = ascent_queue.remove();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
