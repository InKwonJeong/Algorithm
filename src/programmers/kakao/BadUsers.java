package programmers.kakao;

public class BadUsers {
    public static void main(String[] args) {
        String[][] user_ids = {
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}
        };
        String[][] banned_ids = {
                {"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}
        };
        for (int i = 0; i < user_ids.length; i++) {
            System.out.println(new BadUsers().solution(user_ids[i], banned_ids[i]));
        }
    }

    private String[] user, banned, choice;
    private boolean[] visit, check;
    private int answer;
    private boolean finish = false;

    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        banned = banned_id;
        choice = new String[banned_id.length];
        visit = new boolean[user_id.length];
        check = new boolean[banned_id.length];

        answer = 0;
        combination(0, 0);
        return answer;
    }

    private void combination(int start, int depth) {
        if (depth == banned.length) {
            permutation(0);
            if(finish) {
                answer++;
                finish = false;
            }
            return;
        }

        for (int i = start; i < user.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice[depth] = user[i];
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private void permutation(int depth) {
        if(finish)
            return;

        if(depth == choice.length) {
            finish = true;
            return;
        }

        for(int i = 0; i < banned.length; i++) {
            if(!check[i] && check(choice[depth], banned[i])) {
                check[i] = true;
                permutation(depth + 1);
                check[i] = false;
            }
        }
    }

    private boolean check(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && b.charAt(i) != '*')
                return false;
        }
        return true;
    }
}
