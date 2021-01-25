package programmers.kakao;

import java.util.*;

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

    private String[][] relation;
    private int column, answer;
    private int[] key_index;
    private boolean[] visit;
    private List<Set<Integer>> keys;

    public int solution(String[][] relation) {
        this.relation = relation;
        column = relation[0].length;
        visit = new boolean[column];
        keys = new ArrayList<>();
        answer = 0;

        for(int i = 1; i <= column; i++) {
            key_index = new int[i];
            combination(0, 0);
        }

        return answer;
    }

    private void combination(int start, int depth) {
        if(depth == key_index.length) {
            Set<Integer> key = new HashSet<>();
            for(int i = 0; i < visit.length; i++)
                if(visit[i])
                    key.add(i);

            if(isMinimal(key) && isCandidateKey()) {
                keys.add(key);
                answer++;
            }
            return;
        }

        for(int i = start; i < column; i++) {
            if(!visit[i]) {
                visit[i] = true;
                key_index[depth] = i;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private boolean isMinimal(Set<Integer> set) {
        for(Set<Integer> key : keys) {
            if(set.containsAll(key))
                return false;
        }
        return true;
    }

    private boolean isCandidateKey() {
        for(int i = 0; i < relation.length; i++) {
            for(int j = i + 1; j < relation.length; j++) {
                boolean same = true;
                for (int keyIndex : key_index) {
                    if (!relation[i][keyIndex].equals(relation[j][keyIndex])) {
                        same = false;
                        break;
                    }
                }
                if(same)
                    return false;
            }
        }
        return true;
    }
}
