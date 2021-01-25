package programmers.kakao;

import java.util.HashMap;

public class TakingGroupPhoto {
    public static void main(String[] args) {
        int[] n = {2, 2};
        String[][] data = {
                {"N~F=0", "R~T>2"},
                {"M~C<2", "C~M>1"}
        };
        for(int i = 0; i < n.length; i++)
            System.out.println(new TakingGroupPhoto().solution(n[i], data[i]));
    }

    char[] friends;
    Condition[] conditions;
    boolean[] visit;
    HashMap<Character, Integer> map;

    private int answer = 0;

    public int solution(int n, String[] data) {
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visit = new boolean[friends.length];
        conditions = new Condition[data.length];
        map = new HashMap<>();

        for(int i = 0; i < data.length; i++) {
            String d = data[i];
            conditions[i] = new Condition(d.charAt(0), d.charAt(2), d.charAt(3), d.charAt(4));
        }

        permutation(0);
        return answer;
    }

    private void permutation(int index) {
        if(index == friends.length) {
            boolean finish = check();
            if(finish)
                answer++;
            return;
        }

        for(int i = 0; i < friends.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                map.put(friends[i], index);
                permutation(index + 1);
                map.remove(friends[i]);
                visit[i] =false;
            }
        }
    }

    private boolean check() {
        for(Condition condition : conditions) {
            int index1 = map.get(condition.f1);
            int index2 = map.get(condition.f2);
            int diff;
            if(index1 > index2)
                diff = index1 - index2;
            else
                diff = index2 - index1;

            int num = condition.num;
            switch (condition.s) {
                case '=':
                    if(diff != num + 1)
                        return false;
                    break;
                case '>':
                    if(diff <= num + 1)
                        return false;
                    break;
                case '<':
                    if(diff >= num + 1)
                        return false;
                    break;
            }
        }
        return true;
    }

    static class Condition {
        char f1, f2, s;
        int num;

        public Condition(char f1, char f2, char s, char num) {
            this.f1 = f1;
            this.f2 = f2;
            this.s = s;
            this.num = num - '0';
        }
    }
}
