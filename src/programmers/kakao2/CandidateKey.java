package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(new CandidateKey().solution(relation));
    }

    private boolean[] visit;
    private int[] choice;
    private String[][] relation;
    private List<HashSet<Integer>> keys;

    public int solution(String[][] relation) {
        this.relation = relation;
        visit = new boolean[relation[0].length];
        keys = new ArrayList<>();

        for (int i = 1; i <= visit.length; i++) {
            choice = new int[i];
            combination(0, 0);
        }

        return keys.size();
    }

    private boolean identical() {
        for(int i = 0; i < relation.length; i++) {
            for(int j = i + 1; j < relation.length; j++) {
                boolean finish = false;
                for(int c : choice) {
                    if(!relation[i][c].equals(relation[j][c])) {
                        finish = true;
                        break;
                    }
                }
                if(!finish)
                    return false;
            }
        }

        return true;
    }

    private boolean minimal(HashSet<Integer> key) {
        for (HashSet<Integer> k : keys)
            if (key.containsAll(k)) {
                return false;
            }

        return true;
    }

    private void combination(int start, int depth) {
        if (depth == choice.length) {
            HashSet<Integer> key = new HashSet<>();
            for (int i = 0; i < visit.length; i++)
                if (visit[i])
                    key.add(i);

            if (minimal(key) && identical()) {
                keys.add(key);
            }

            return;
        }

        for (int i = start; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice[depth] = i;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
