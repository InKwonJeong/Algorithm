package programmers.kakao2;

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
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> a = new HashMap<>();
        HashMap<String, Integer> b = new HashMap<>();
        for(int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if(sub.matches("[a-z][a-z]")) {
                a.put(sub, a.getOrDefault(sub, 0) + 1);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if(sub.matches("[a-z][a-z]")) {
                b.put(sub, b.getOrDefault(sub, 0) + 1);
            }
        }

        int intersect = 0;
        int union = 0;

        for(String key : a.keySet()) {
            if(b.get(key) != null) {
                intersect += Math.min(a.get(key), b.get(key));
                union += Math.max(a.get(key), b.get(key));
            } else {
                union += a.get(key);
            }
        }

        for(String key : b.keySet()) {
            if(a.get(key) == null) {
                union += b.get(key);
            }
        }

        double value;
        if(union == 0)
            value = 1;
        else
            value = (double) intersect / union;

        answer = (int) (value * 65536);
        return answer;
    }
}
