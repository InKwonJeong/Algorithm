package codingtest.kakao;

import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) {
        int[][] numbers = {
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };
        String[] hand = {
                "right",
                "left",
                "right"
        };
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(new Problem1().solution(numbers[i], hand[i]));
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        HashMap<Integer, Point> map = new HashMap<>();
        map.put(1, new Point(0, 0));
        map.put(2, new Point(0, 1));
        map.put(3, new Point(0, 2));
        map.put(4, new Point(1, 0));
        map.put(5, new Point(1, 1));
        map.put(6, new Point(1, 2));
        map.put(7, new Point(2, 0));
        map.put(8, new Point(2, 1));
        map.put(9, new Point(2, 2));
        map.put(0, new Point(3, 1));

        Point left = new Point(3, 0);
        Point right = new Point(3, 2);

        for(int number : numbers) {
            if(number == 0 || number % 3 == 2) {
                Point point = map.get(number);
                int left_distance = Math.abs(point.x - left.x) + Math.abs(point.y - left.y);
                int right_distance = Math.abs(point.x - right.x) + Math.abs(point.y - right.y);
                if(left_distance > right_distance) {
                    answer.append("R");
                    right = point;
                } else if(left_distance < right_distance) {
                    answer.append("L");
                    left = point;
                } else {
                    if(hand.equals("right")) {
                        answer.append("R");
                        right = point;
                    } else {
                        answer.append("L");
                        left = point;
                    }
                }
            } else if(number % 3 == 0) {
                answer.append("R");
                right = map.get(number);
            } else if(number % 3 == 1) {
                answer.append("L");
                left = map.get(number);
            }
        }

        return answer.toString();
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
