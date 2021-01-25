package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class OXQuiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            String str = input.next();
            int total = 0;
            int count = 1;
            for(char c : str.toCharArray()) {
                if(c == 'O') {
                    total += count++;
                } else {
                    count = 1;
                }
            }
            System.out.println(total);
            t--;
        }
    }
}
