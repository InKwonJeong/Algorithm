package baekjoon.implementation;

import java.util.Scanner;

public class STROJOPIS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] answer = new int[8];
        char[][] d = new char[8][];

        d[0] = new char[] {'1', 'Q', 'A', 'Z'};
        d[1] = new char[] {'2', 'W', 'S', 'X'};
        d[2] = new char[] {'3', 'E', 'D', 'C'};
        d[3] = new char[] {'4', '5', 'R', 'T', 'F', 'G', 'V', 'B'};
        d[4] = new char[] {'6', '7', 'Y', 'U', 'H', 'J', 'N', 'M'};
        d[5] = new char[] {'8', 'I', 'K', ','};
        d[6] = new char[] {'9', 'O', 'L', '.'};
        d[7] = new char[] {'0', '-', '=', 'P', '[', ']', ';', '\'', '/'};

        String str = input.next();
        for(int i = 0; i < str.length(); i++) {
            boolean done = false;
            for(int j = 0; j < 8; j++) {
                if(done)
                    break;
                for(int k = 0; k < d[j].length; k++) {
                    if(str.charAt(i) == d[j][k]) {
                        answer[j]++;
                        done = true;
                        break;
                    }
                }
            }
        }

        for(int i : answer)
            System.out.println(i);
    }
}
