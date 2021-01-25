package baekjoon.stage.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers2 {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bf.readLine());
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++)
                list.add(Integer.parseInt(bf.readLine()));

            Collections.sort(list);
            for(int b : list)
                bw.write(b + "\n");

            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
