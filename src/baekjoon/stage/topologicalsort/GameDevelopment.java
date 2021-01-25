package baekjoon.stage.topologicalsort;

import java.util.*;

public class GameDevelopment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] answer = new int[n + 1];
        int[] time = new int[n + 1];
        int[] count = new int[n + 1];
        List<Integer>[] nodes = new List[n + 1];
        for(int i = 1; i <= n; i++)
            nodes[i] = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            time[i] = input.nextInt();
            while (true) {
                int node = input.nextInt();
                if(node == -1) break;
                nodes[node].add(i);
                count[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                queue.add(i);
                answer[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int next : nodes[node]) {
                count[next]--;
                answer[next] = Math.max(answer[next], answer[node] + time[next]);

                if(count[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}
