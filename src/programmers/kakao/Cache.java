package programmers.kakao;

import java.util.*;

public class Cache {
    public static void main(String[] args) {
        int[] cacheSize = {3,3,2,5,2,0};
        String[][] cities = {
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
                {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"},
                {"Jeju", "Pangyo", "NewYork", "newyork"},
                {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
        };
        for(int i = 0; i < cacheSize.length; i++) {
            System.out.println(new Cache().solution(cacheSize[i], cities[i]));
        }
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> list = new ArrayList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (list.size() < cacheSize) {
                if (list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer += 1;
                } else {
                    list.add(city);
                    answer += 5;
                }
            } else if(cacheSize != 0) {
                if (list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer += 1;
                } else {
                    list.remove(0);
                    list.add(city);
                    answer += 5;
                }
            } else {
                answer += 5;
            }
        }

        return answer;
    }
}
