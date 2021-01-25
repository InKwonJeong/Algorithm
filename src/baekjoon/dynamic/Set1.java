package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Set1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder builder = new StringBuilder();
        int s = 0;
        int num = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    s |= (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    s &= ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if ((s & (1 << num)) == 0)
                        builder.append(0).append("\n");
                    else
                        builder.append(1).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    s ^= (1 << num);
                    break;
                case "all":
                    s = (1 << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.println(builder);
    }
}
