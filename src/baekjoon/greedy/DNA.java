package baekjoon.greedy;

import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        char[][] dna = new char[n][m];
        char[] dna_answer = new char[m];
        int hamming_distance = 0;
        char[] types = {'A', 'C', 'G', 'T'};

        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                dna[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < m; i++) {
            int[] count = new int[4];
            for(int j = 0; j < n; j++) {
                for(int t = 0; t < types.length; t++) {
                    if(dna[j][i] == types[t]) {
                        count[t]++;
                        break;
                    }
                }
            }
            int index = index(count);
            hamming_distance += n - count[index];
            dna_answer[i] = types[index];
        }

        for(char c : dna_answer)
            System.out.print(c);
        System.out.println("\n" + hamming_distance);

    }

    private static int index(int[] count) {
        int index = 0;
        for(int i = 1; i < count.length; i++) {
            if(count[index] < count[i])
                index = i;
        }
        return index;
    }


}
