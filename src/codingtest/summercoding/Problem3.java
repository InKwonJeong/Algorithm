package codingtest.summercoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        int total_sp = 120;
        int[][] skills = {
                {1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}, {5, 7}
        };
        System.out.println(Arrays.toString(new Problem3().solution(total_sp, skills)));
    }

    private int[] points;
    private List<Integer>[] graph;

    public int[] solution(int total_sp, int[][] skills) {
        int n = skills.length + 1;
        int[] count = new int[n + 1];
        points = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int[] skill : skills) {
            graph[skill[0]].add(skill[1]);
            count[skill[1]]++;
        }

        int root = 0;
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                root = i;
                break;
            }
        }

        getPoint(root);

        int total = 0;
        for(int i = 1; i <= n; i++) {
            total += points[i];
        }

        int sp = total_sp / total;

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = points[i + 1] * sp;
        }

        return answer;
    }

    private int getPoint(int root) {
        if(points[root] != 0)
            return points[root];

        if(graph[root].isEmpty()) {
            points[root] = 1;
            return 1;
        } else {
            int point = 0;
            for(int child : graph[root]) {
                point += getPoint(child);
            }
            points[root] = point;
            return point;
        }
    }
}
