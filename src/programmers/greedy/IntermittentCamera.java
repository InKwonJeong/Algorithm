package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IntermittentCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(new IntermittentCamera().solution(routes));
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Car[] cars = new Car[routes.length];
        for(int i = 0; i < routes.length; i++)
            cars[i] = new Car(routes[i][0], routes[i][1]);

        Arrays.sort(cars, Comparator.comparingInt(o -> o.end));
        int index = 0;
        while (index < cars.length) {
            answer++;
            int end = cars[index++].end;
            for(int i = index; i < cars.length; i++) {
                if(end >= cars[i].start) {
                    index = i + 1;
                } else
                    break;
            }
        }

        return answer;
    }

    static class Car {
        int start, end;

        public Car(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
