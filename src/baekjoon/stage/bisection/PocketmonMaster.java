package baekjoon.stage.bisection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PocketmonMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String pocketmon = br.readLine();
            String index = String.valueOf(i);
            map.put(index, pocketmon);
            map.put(pocketmon, index);
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= m; i++) {
            String str = br.readLine();
            builder.append(map.get(str)).append("\n");
        }

        System.out.println(builder);
    }
}
