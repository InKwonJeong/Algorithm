package baekjoon.stage.unionfind;

import java.util.Scanner;

public class RoomCleaning {

    private static int[] parents;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Drink[] drinks = new Drink[n + 1];
        parents = new int[m + 1];

        for(int i = 1; i <= n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            drinks[i] = new Drink(a, b);
        }

        for(int i = 1; i <= m; i++)
            parents[i] = i;

        boolean[] visit = new boolean[m + 1];
        for(int i = 1; i <= n; i++) {
            boolean finish = true;
            Drink drink = drinks[i];
            if(!visit[drink.a]) {
                visit[drink.a] = true;
                union(drink.a, drink.b);
            } else if(!visit[drink.b]) {
                visit[drink.b] = true;
                union(drink.b, drink.a);
            } else {
                int p1 = find(drink.a);
                int p2 = find(drink.b);
                if(!visit[p1]) {
                    visit[p1] = true;
                    union(p1, p2);
                } else if(!visit[p2]) {
                    visit[p2] = true;
                    union(p2, p1);
                } else {
                    finish = false;
                }
            }

            if(finish)
                System.out.println("LADICA");
            else
                System.out.println("SMECE");
        }
    }

    private static int find(int node) {
        int parent = parents[node];
        if(parent == node)
            return node;

        parents[node] = find(parent);
        return parents[node];
    }

    private static void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if(p1 != p2)
            parents[p1] = p2;
    }

    static class Drink {
        int a, b;

        public Drink(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
