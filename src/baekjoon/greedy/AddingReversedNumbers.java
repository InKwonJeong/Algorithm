package baekjoon.greedy;

import java.util.Scanner;

public class AddingReversedNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int num1 = reverse(input.nextInt());
            int num2 = reverse(input.nextInt());
            answer[i] = reverse(num1 + num2);
        }

        for (int a : answer)
            System.out.println(a);
    }

    private static int reverse(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed *= 10;
            reversed += number % 10;
            number /= 10;
        }
        return reversed;
    }
}
