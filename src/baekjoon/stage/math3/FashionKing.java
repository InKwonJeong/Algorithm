package baekjoon.stage.math3;

import java.util.HashMap;
import java.util.Scanner;

public class FashionKing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                String name = input.next();
                String type = input.next();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(String key : map.keySet())
                answer *= (map.get(key) + 1);

            System.out.println(answer - 1);
            t--;
        }
    }
}
