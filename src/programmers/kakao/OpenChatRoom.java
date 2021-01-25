package programmers.kakao;

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
        HashMap<String, User> map = new HashMap<>();
        List<UserState> list = new ArrayList<>();
        for (String rec : record) {
            String[] words = rec.split(" ");
            User user = map.get(words[1]);
            if (words[0].equals("Enter")) {
                if (user == null) {
                    user = new User(words[1], words[2]);
                    map.put(words[1], user);
                } else {
                    user.nickname = words[2];
                }
                list.add(new UserState(user, true));
            } else if (words[0].equals("Leave")) {
                list.add(new UserState(user, false));
            } else {
                user.nickname = words[2];
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            UserState state = list.get(i);
            if (state.enter) {
                answer[i] = state.user.nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = state.user.nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    static class User {
        String uid, nickname;

        User(String uid, String nickname) {
            this.uid = uid;
            this.nickname = nickname;
        }
    }

    static class UserState {
        User user;
        boolean enter;

        UserState(User user, boolean enter) {
            this.user = user;
            this.enter = enter;
        }
    }
}
