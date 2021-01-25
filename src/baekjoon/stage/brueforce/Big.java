package baekjoon.stage.brueforce;

import java.util.Scanner;

public class Big {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] ranks = new int[n];
        Person[] people = new Person[n];
        for(int i = 0; i < n; i++)
            people[i] = new Person(input.nextInt(), input.nextInt());

        for(int i = 0; i < n; i++) {
            int rank = 1;
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    if(people[i].height < people[j].height && people[i].weight < people[j].weight)
                        rank++;
                }
            }
            ranks[i] = rank;
        }

        for(int rank : ranks)
            System.out.print(rank + " ");
    }

    static class Person {
        int weight, height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
