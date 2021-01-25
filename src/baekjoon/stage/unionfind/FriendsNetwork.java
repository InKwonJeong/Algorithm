package baekjoon.stage.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FriendsNetwork {

    private static HashMap<String, String> parents;
    private static HashMap<String, Integer> numbers;

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            parents = new HashMap<>();
            numbers = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (n --> 0) {
                st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                String parent1 = find(friend1);
                String parent2 = find(friend2);
                if(!parent1.equals(parent2)) {
                    union(parent1, parent2);
                }

                builder.append(numbers.get(parent2)).append("\n");
            }
        }

        System.out.println(builder);
    }

    private static String find(String friend) {
        String parent = parents.get(friend);
        if (parent == null)
            return friend;

        parents.put(friend, find(parent));
        return parents.get(friend);
    }

    private static void union(String friend1, String friend2) {
        String parent1 = find(friend1);
        String parent2 = find(friend2);

        if (!parent1.equals(parent2)) {
            parents.put(parent1, parent2);
            numbers.put(parent2,
                    numbers.getOrDefault(parent1, 1)
                            + numbers.getOrDefault(parent2, 1));
        }
    }
}
