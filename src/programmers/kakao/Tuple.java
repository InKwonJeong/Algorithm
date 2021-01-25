package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;

public class Tuple {
    public static void main(String[] args) {
        String[] s = {
                "{{2},{2,1},{2,1,3},{2,1,3,4}}",
                "{{1,2,3},{2,1},{1,2,4,3},{2}}",
                "{{20,111},{111}}",
                "{{123}}",
                "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        };
        for(int i = 0; i < s.length; i++)
            System.out.println(Arrays.toString(new Tuple().solution(s[i])));
    }

    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num *= 10;
                num += s.charAt(i) - '0';
            } else {
                if(num != 0) {
                    map.put(num, map.getOrDefault(num , 0) + 1);
                    num = 0;
                }
            }
        }
        Entry[] entries = new Entry[map.size()];
        int[] answer = new int[map.size()];
        int index = 0;

        for(Integer key: map.keySet()) {
            entries[index] = new Entry(key, map.get(key));
            index++;
        }

        Arrays.sort(entries, (o1, o2) -> Integer.compare(o2.value, o1.value));
        for(int i = 0; i < entries.length; i++) {
            answer[i] = entries[i].key;
        }
        return answer;
    }

    static class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
