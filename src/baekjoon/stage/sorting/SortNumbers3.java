package baekjoon.stage.sorting;

import java.io.*;

public class SortNumbers3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(i + "\n");

                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
