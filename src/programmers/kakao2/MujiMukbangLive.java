package programmers.kakao2;

import java.util.Arrays;
import java.util.Comparator;

public class MujiMukbangLive {
    public static void main(String[] args) {
        int[][] food_times = {
                {3, 1, 2},
                {1, 2, 3, 4, 5, 6},
                {1, 5, 7, 7, 7, 8, 9, 10}
        };
        long[] k = {1, 20, 53};
        for (int i = 0; i < food_times.length; i++)
            System.out.println(new MujiMukbangLive().solution(food_times[i], k[i]));
    }

    public int solution(int[] food_times, long k) {
        Food[] foods = new Food[food_times.length];
        for (int i = 0; i < food_times.length; i++)
            foods[i] = new Food(i, food_times[i]);

        Arrays.sort(foods, Comparator.comparingInt(o -> o.time));
        int time = 0;
        int index = foods.length;
        for (int i = 0; i < foods.length; i++) {
            if(time < foods[i].time) {
                long total = (long) (foods[i].time - time) * (foods.length - i);
                if(k >= total) {
                    k -= total;
                    time = foods[i].time;
                } else {
                    index = i;
                    break;
                }
            }
        }

        if(index == foods.length)
            return -1;

        Food[] left_foods = new Food[foods.length - index];
        for(int i = 0; i < left_foods.length; i++)
            left_foods[i] = foods[index + i];
        Arrays.sort(left_foods, Comparator.comparingInt(o -> o.index));
        return left_foods[(int) (k % left_foods.length)].index + 1;
    }

    static class Food {
        int index, time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
