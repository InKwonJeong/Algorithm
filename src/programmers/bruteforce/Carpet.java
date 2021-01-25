package programmers.bruteforce;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int[] brown = {10, 8, 24};
        int[] red = {2, 1, 24};
        for(int i = 0; i < brown.length; i++)
            System.out.println(Arrays.toString(new Carpet().solution(brown[i], red[i])));
    }

    public int[] solution(int brown, int red) {
        int height = 0;
        int width = 0;
        int total = brown + red;
        for(int i = 2; i * i <= total; i++) {
            if(total % i == 0) {
                height = i;
                width = total / height;

                int border = 2 * width + 2 * height - 4;
                if(border == brown)
                    break;
            }
        }

        return new int[]{width, height};
    }
}
