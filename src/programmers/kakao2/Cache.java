package programmers.kakao2;

import java.util.LinkedList;
import java.util.List;

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
        List<String> list = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if(list.contains(city)) {
                list.remove(city);
                list.add(city);
                answer++;
            } else if(cacheSize > 0) {
                if(list.size() >= cacheSize)
                    list.remove(0);
                list.add(city);
                answer += 5;
            } else
                answer += 5;
        }
        return answer;
    }
}
