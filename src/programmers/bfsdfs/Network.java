package programmers.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int[] n = {3, 3};
        int[][][] computers = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
        };
        for(int i = 0; i < n.length; i++)
            System.out.println(new Network().solution(n[i], computers[i]));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                answer++;
                queue.offer(i);
                visit[i] = true;
                while (!queue.isEmpty()) {
                    int computer = queue.poll();
                    for(int j = 0; j < n; j++) {
                        if(!visit[j] && computers[computer][j] == 1) {
                            queue.offer(j);
                            visit[j] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
