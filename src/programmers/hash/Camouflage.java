package programmers.hash;

import java.util.HashMap;

public class Camouflage {
    public static void main(String[] args) {
        String[][][] clothes = {
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}},
                {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}
        };
        for (String[][] cloth : clothes)
            System.out.println(new Camouflage().solution(cloth));
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);

        int answer = 1;
        for(String type : map.keySet()) {
            answer *= map.get(type) + 1;
        }

        return answer - 1;
    }
}
