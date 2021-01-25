package programmers.kakao2;

import java.util.Arrays;
import java.util.HashMap;

public class SearchLyric {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        System.out.println(Arrays.toString(new SearchLyric().solution(words, queries)));
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie root = new Trie('*');
        for (String word : words) {
            Trie parent = root;
            for (char c : word.toCharArray()) {
                parent.putChild(c, word.length());
                parent = parent.getChild(c);
            }
        }

        Trie reverse_root = new Trie('*');
        for (String word : words) {
            Trie parent = reverse_root;
            for (int i = word.length() - 1; i >= 0; i--) {
                parent.putChild(word.charAt(i), word.length());
                parent = parent.getChild(word.charAt(i));
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) == '?') {
                Trie parent = reverse_root;
                for (int j = query.length() - 1; j >= 0; j--) {
                    char c = query.charAt(j);
                    if (c == '?') {
                        answer[i] = parent.getNumOfLength(query.length());
                        break;
                    } else {
                        if (parent.getChild(c) == null) {
                            answer[i] = 0;
                            break;
                        } else {
                            parent = parent.getChild(c);
                        }
                    }
                }
            } else {
                Trie parent = root;
                for (char c : query.toCharArray()) {
                    if (c == '?') {
                        answer[i] = parent.getNumOfLength(query.length());
                    } else {
                        if (parent.getChild(c) == null) {
                            answer[i] = 0;
                            break;
                        } else {
                            parent = parent.getChild(c);
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numOfChildren;

        Trie(char c) {
            this.c = c;
            children = new HashMap<>();
            numOfChildren = new HashMap<>();
        }

        void putChild(char c, int length) {
            if (children.get(c) == null) {
                Trie child = new Trie(c);
                children.put(c, child);
            }

            numOfChildren.put(length, numOfChildren.getOrDefault(length, 0) + 1);
        }

        Trie getChild(char c) {
            return children.get(c);
        }

        int getNumOfLength(int length) {
            if (numOfChildren.get(length) == null)
                return 0;
            else
                return numOfChildren.get(length);
        }
    }
}
