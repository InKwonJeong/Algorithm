package programmers.hash;

import java.util.HashMap;

public class IncompletePlayer {
    public static void main(String[] args) {
        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        for(int i = 0; i < participants.length; i++) {
            System.out.println(new IncompletePlayer().solution(participants[i], completions[i]));
        }
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String name : completion)
            map.put(name, map.getOrDefault(name, 0) + 1);

        for(String name : participant) {
            Integer num = map.get(name);
            if(num != null) {
                if(num != 1)
                    map.put(name, map.get(name) - 1);
                else
                    map.remove(name);
            } else {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
