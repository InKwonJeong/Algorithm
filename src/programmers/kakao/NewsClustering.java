package programmers.kakao;

import java.util.HashMap;

public class NewsClustering {
    public static void main(String[] args) {
        String[] str1 = {
                "FRANCE", "handshake", "aa1+aa2", "E=M*C^2"
        };
        String[] str2 = {
                "french", "shake hands", "AAAA12", "e=m*c^2"
        };
        for(int i = 0; i < str1.length; i++)
            System.out.println(new NewsClustering().solution(str1[i], str2[i]));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if(c1 >= 'a' && c2 >= 'a' && c1 <= 'z' && c2 <= 'z') {
                String str = str1.substring(i, i + 2);
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if(c1 >= 'a' && c2 >= 'a' && c1 <= 'z' && c2 <= 'z') {
                String str = str2.substring(i, i + 2);
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }

        double intersection = 0;
        double union = 0;

        for(String key : map1.keySet()) {
            if(map2.get(key) != null) {
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }

        for(String key : map2.keySet()) {
            if(map1.get(key) == null) {
                union += map2.get(key);
            }
        }

        double jaccard = 0;
        if(union == 0)
            jaccard = 1;
        else
            jaccard = intersection / union;

        return (int) (jaccard * 65536);
    }
}
