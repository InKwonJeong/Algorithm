package baekjoon.stage.math2;

import java.util.Scanner;

public class Turret {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            double r1 = input.nextDouble();
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            double r2 = input.nextDouble();

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
                t--;
                continue;
            }

            double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            double radius1 = r1 + r2;
            double radius2 = Math.abs(r1 - r2);

            if(distance < radius1 && distance > radius2)
                System.out.println(2);
            else if(distance == radius1 || distance == radius2)
                System.out.println(1);
            else
                System.out.println(0);

            t--;
        }
    }
}
