package baekjoon.greedy;

import java.util.*;

public class Thirty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.next();
        List<Integer> list = new ArrayList<>();

        int total = 0;
        int zero = 0;
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if(num == 0)
                zero++;
            total += num;
            list.add(num);
        }

        if(total % 3 == 0 && zero > 0) {
            list.sort(Comparator.reverseOrder());
            for(int l : list)
                System.out.print(l);
        } else
            System.out.println(-1);
    }
}
