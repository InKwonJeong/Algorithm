package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int f = input.nextInt(); // 총 층수
        int s = input.nextInt(); // 현재 있는 층
        int g = input.nextInt(); // 가야 하는 층
        int u = input.nextInt(); // 한번에 위로 가는 층수
        int d = input.nextInt(); // 한번에 아래로 가는 층수

        int[] dx = {u, -d};

        boolean[] visit = new boolean[f + 1];
        Queue<Floor> queue = new LinkedList<>();
        queue.offer(new Floor(s, 0));
        visit[s] = true;
        while (!queue.isEmpty()) {
            Floor floor = queue.poll();
            if(floor.f == g) {
                System.out.println(floor.count);
                return;
            }
            for(int i = 0; i < 2; i++) {
                int nx = floor.f + dx[i];
                if(nx < 1 || nx > f)
                    continue;
                if(!visit[nx]) {
                    queue.offer(new Floor(nx, floor.count + 1));
                    visit[nx] = true;
                }
            }
        }
        System.out.println("use the stairs");
    }

    static class Floor {
        int f, count;
        Floor(int f, int count) {
            this.f = f;
            this.count = count;
        }
    }
}
