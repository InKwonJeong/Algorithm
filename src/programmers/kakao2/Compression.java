package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Compression {
    public static void main(String[] args) {
        String[] msgs = {
                "KAKAO",
                "TOBEORNOTTOBEORTOBEORNOT",
                "ABABABABABABABAB",
                "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS"
        };
        for(String msg : msgs)
            System.out.println(Arrays.toString(new Compression().solution(msg)));
    }

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= 26; i++) {
            char c = (char) ('A' + i - 1);
            map.put(c + "", i);
        }

        int index = 27;
        int start = 0;
        for(int i = 0; i < msg.length(); i++) {
            String sub = msg.substring(start, i + 1);
            if(map.get(sub) == null) {
                map.put(sub, index++);
                list.add(map.get(msg.substring(start, i)));
                start = i--;
            }
        }

        list.add(map.get(msg.substring(start)));

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
