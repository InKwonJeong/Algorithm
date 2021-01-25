package baekjoon.stage.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MusicProgram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[n + 1];
        List<Integer>[] orders = new List[n + 1];
        for(int i = 1; i <= n; i++)
            orders[i] = new ArrayList<>();

        while (m --> 0) {
            String[] singers = br.readLine().split(" ");
            for(int i = 1; i < singers.length - 1; i++) {
                int pre = Integer.parseInt(singers[i]);
                for(int j = i + 1; j < singers.length; j++) {
                    int post = Integer.parseInt(singers[j]);
                    orders[pre].add(post);
                    count[post]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int singer = queue.poll();
            order.add(singer);

            for(int next : orders[singer]) {
                count[next]--;

                if(count[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if(order.size() == n) {
            for(int o : order)
                System.out.println(o);
        } else {
            System.out.println(0);
        }
    }
}
