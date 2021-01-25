package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NewRecruits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int[] d = new int[n];
            Person[] people = new Person[n];

            for (int i = 0; i < n; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                people[i] = new Person(a, b);
            }

            Arrays.sort(people, Comparator.comparingInt(o -> o.a));
            for(int i = 0; i < n; i++)
                d[i] = people[i].b;

            int answer = 1;
            int min = d[0];
            for(int i = 1; i < n; i++) {
                if(min > d[i]) {
                    min = d[i];
                    answer++;
                }
            }

            System.out.println(answer);
            t--;
        }
    }

    static class Person {
        int a, b;

        Person(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
