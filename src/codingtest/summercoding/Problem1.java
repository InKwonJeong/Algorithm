package codingtest.summercoding;

import java.util.HashSet;

public class Problem1 {
    public static void main(String[] args) {
        int[] p = {1000, 1987, 2015, 10000};
        for(int a : p)
            System.out.println(new Problem1().solution(a));
    }

    public int solution(int p) {
        int num = p + 1;
        int answer = 0;
        boolean finish = false;
        while (!finish) {
            HashSet<Integer> set = new HashSet<>();
            int a = num;
            finish = true;
            answer = num;
            while (a > 0) {
                int b = a % 10;
                if(!set.contains(b)) {
                    a /= 10;
                    set.add(b);
                } else {
                    finish = false;
                    break;
                }
            }
            num++;
        }
        return answer;
    }
}
