package baekjoon.stage.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Workbook {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] count = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        while (m --> 0) {
            int a = input.nextInt();
            int b = input.nextInt();

            graph[a].add(b);
            count[b]++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0)
                priorityQueue.add(i);
        }

        while (!priorityQueue.isEmpty()) {
            int node = priorityQueue.poll();
            builder.append(node).append(" ");

            for(int other : graph[node]) {
                count[other]--;
                if(count[other] == 0) {
                    priorityQueue.add(other);
                }
            }
        }

        System.out.println(builder);
    }
}
