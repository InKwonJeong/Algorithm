package baekjoon.stage.math1;

import java.util.Scanner;

public class FlyMeToTheAlphaCentauri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            int movingDistance = 0;
            int xMovingCount = 0;
            int yMovingCount = 0;

            while(true) {
                movingDistance++;
                x += movingDistance;
                xMovingCount++; // x의 이동횟수

                if(x >= y) {
                    break;
                }

                y -= movingDistance;
                yMovingCount++; // y의 이동횟수

                if(y <= x) {
                    break;
                }
            }
            System.out.println(xMovingCount + yMovingCount);
            t--;
        }
    }
}
