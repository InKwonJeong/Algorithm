package baekjoon.stage.forstatement;

import java.io.*;
import java.util.StringTokenizer;

public class FastAPlusB {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int t = Integer.parseInt(bf.readLine());
            while (t > 0) {
                String line = bf.readLine();
                StringTokenizer st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bw.write((a + b) + "\n");
                t--;
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
