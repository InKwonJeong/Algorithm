package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;

public class SearchLyric {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "programmers/kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(new SearchLyric().solution(words, queries)));
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie root = new Trie('*');
        for (String word : words) {
            Trie parent = root;
            for (int j = 0; j < word.length(); j++) {
                Trie child = new Trie(word.charAt(j));
                parent = parent.put(child, word.length());
            }
        }

        Trie reverse = new Trie('*');
        for (String word : words) {
            Trie parent = reverse;
            for (int j = word.length() - 1; j >= 0; j--) {
                Trie child = new Trie(word.charAt(j));
                parent = parent.put(child, word.length());
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) == '?') {
                Trie parent = reverse;
                for (int j = query.length() - 1; j >= 0; j--) {
                    if (query.charAt(j) == '?') {
                        answer[i] = parent.getNumsOfChildrenLens(query.length());
                        break;
                    }
                    parent = parent.get(query.charAt(j));
                    if (parent == null) {
                        answer[i] = 0;
                        break;
                    }
                }
            } else {
                Trie parent = root;
                for (int j = 0; j < query.length(); j++) {
                    if (query.charAt(j) == '?') {
                        answer[i] = parent.getNumsOfChildrenLens(query.length());
                        break;
                    }
                    parent = parent.get(query.charAt(j));
                    if (parent == null) {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numOfChildrenLens;

        Trie(char c) {
            this.c = c;
            children = new HashMap<>();
            numOfChildrenLens = new HashMap<>();
        }

        public Trie put(Trie t, int len) {
            children.putIfAbsent(t.c, t);
            numOfChildrenLens.put(len, numOfChildrenLens.getOrDefault(len, 0) + 1);
            return children.get(t.c);
        }

        public Trie get(char c) {
            return children.get(c);
        }

        public int getNumsOfChildrenLens(int len) {
            return numOfChildrenLens.get(len) != null ? numOfChildrenLens.get(len) : 0;
        }
    }
}
