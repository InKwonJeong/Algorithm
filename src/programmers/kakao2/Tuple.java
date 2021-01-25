package programmers.kakao2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tuple {
    public static void main(String[] args) {
        String[] S = {
                "{{2},{2,1},{2,1,3},{2,1,3,4}}",
                "{{1,2,3},{2,1},{1,2,4,3},{2}}",
                "{{20,111},{111}}",
                "{{123}}",
                "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        };
        for (String s : S)
            System.out.println(Arrays.toString(new Tuple().solution(s)));
    }

    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int value = 0;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                value *= 10;
                value += c - '0';
            } else {
                if(value != 0) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    value = 0;
                }
            }
        }

        Map.Entry<Integer, Integer>[] entry = new Map.Entry[map.size()];
        map.entrySet().toArray(entry);
        Arrays.sort(entry, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        int[] answer = new int[map.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = entry[i].getKey();

        return answer;
    }
}
