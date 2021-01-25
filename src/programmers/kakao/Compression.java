package programmers.kakao;

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
        for(int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            map.put(String.valueOf(letter), i + 1);
        }

        int last_index = 27;
        int i = 0;
        while (i < msg.length()) {
            int index = 0;
            int start = i;
            for(int j = 1; j <= msg.length() - start; j++) {
                String letter = msg.substring(start, start + j);
                if(map.get(letter) == null) {
                    map.put(letter, last_index++);
                    break;
                } else {
                    index = map.get(letter);
                    i++;
                }
            }
            list.add(index);
        }

        int[] answer = new int[list.size()];
        for(i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}
