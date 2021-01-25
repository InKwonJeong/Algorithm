package baekjoon.stage.onedimensionalarray;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] a = new double[n];
        double max = 0;
        for(int i = 0; i < a.length; i++) {
            double b = input.nextDouble();
            if(max < b)
                max = b;
            a[i] = b;
        }

        double total = 0;
        for(int i = 0; i < a.length; i++) {
            a[i] = a[i] / max * 100;
            total += a[i];
        }

        System.out.println(total / n);
    }
}
