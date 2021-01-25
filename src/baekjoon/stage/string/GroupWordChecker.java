package baekjoon.stage.string;

import java.util.HashSet;
import java.util.Scanner;

public class GroupWordChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int answer = 0;
        while (t > 0) {
            String s = input.next();
            HashSet<Character> set = new HashSet<>();
            char prev = ' ';
            boolean finish = true;
            for(char c : s.toCharArray()) {
                if(prev != c) {
                    if(set.contains(c)) {
                        finish = false;
                        break;
                    } else {
                        set.add(c);
                    }
                }
                prev = c;
            }
            if(finish)
                answer++;
            t--;
        }
        System.out.println(answer);
    }
}
