package baekjoon.bdfs;

import java.util.*;

public class FamilyTree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int m = input.nextInt();
        boolean[] visit = new boolean[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        int answer = -1;

        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person(a, 0));
        visit[a] = true;
        while (!queue.isEmpty()) {
            Person p = queue.poll();
            if(p.num == b) {
                answer = p.count;
                break;
            }

            for(int i : graph[p.num]) {
                if(!visit[i]) {
                    queue.offer(new Person(i, p.count + 1));
                    visit[i] = true;
                }
            }
        }

        System.out.println(answer);
    }

    static class Person {
        int num, count;
        Person(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
