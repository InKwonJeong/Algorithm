package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpenChatRoom {
    public static void main(String[] args) {
        String[] record =
                {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new OpenChatRoom().solution(record)));
    }

    public String[] solution(String[] record) {
        List<Record> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(String r : record) {
            String[] s = r.split(" ");
            if(s[0].equals("Enter")) {
                map.put(s[1], s[2]);
                list.add(new Record(s[0], s[1]));
            } else if(s[0].equals("Leave")) {
                list.add(new Record(s[0], s[1]));
            } else {
                map.put(s[1], s[2]);
            }
        }

        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            Record r = list.get(i);
            if(r.behavior.equals("Enter")) {
                answer[i] = String.format("%s님이 들어왔습니다.", map.get(r.uid));
            } else {
                answer[i] = String.format("%s님이 나갔습니다.", map.get(r.uid));
            }
        }
        return answer;
    }

    static class Record {
        String behavior, uid;

        public Record(String behavior, String uid) {
            this.behavior = behavior;
            this.uid = uid;
        }
    }
}
