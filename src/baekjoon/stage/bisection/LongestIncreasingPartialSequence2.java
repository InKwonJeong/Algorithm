package baekjoon.stage.bisection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingPartialSequence2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0; i < n; i++) {
            int num = input.nextInt();
            if(list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if(list.get(mid) >= num) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(end, num);
            }
        }
        System.out.println(list.size() - 1);
    }
}
