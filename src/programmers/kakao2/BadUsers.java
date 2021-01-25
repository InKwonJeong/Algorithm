package programmers.kakao2;

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

    private String[] user_id, banned_id;
    private boolean[] visit, check;
    private String[] choice, ids;
    private int answer;
    private boolean finish;

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        choice = new String[banned_id.length];
        ids = new String[banned_id.length];
        check = new boolean[banned_id.length];
        visit = new boolean[user_id.length];

        combination(0, 0);

        return answer;
    }

    private void combination(int start, int depth) {
        if (depth == banned_id.length) {
            finish = false;
            permutation(0);
            return;
        }

        for (int i = start; i < user_id.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice[depth] = user_id[i];
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private void permutation(int depth) {
        if (finish)
            return;

        if (depth == banned_id.length) {
            if (check()) {
                answer++;
                finish = true;
            }
            return;
        }

        for (int i = 0; i < choice.length; i++) {
            if (!check[i]) {
                check[i] = true;
                ids[depth] = choice[i];
                permutation(depth + 1);
                check[i] = false;
            }
        }
    }

    private boolean check() {
        for (int i = 0; i < banned_id.length; i++) {
            String id1 = ids[i];
            String id2 = banned_id[i];
            if (id1.length() != id2.length())
                return false;

            for (int j = 0; j < id1.length(); j++) {
                if (!(id1.charAt(j) == id2.charAt(j) || id2.charAt(j) == '*')) {
                    return false;
                }
            }

        }
        return true;
    }
}
