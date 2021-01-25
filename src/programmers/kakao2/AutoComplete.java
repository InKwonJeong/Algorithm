package programmers.kakao2;

import java.util.HashMap;

public class AutoComplete {
    public static void main(String[] args) {
        String[][] words = {
                {"go", "gone", "guild"},
                {"abc", "def", "ghi", "jklm"},
                {"word", "war", "warrior", "world"}
        };
        for(String[] word : words)
            System.out.println(new AutoComplete().solution(word));
    }

    public int solution(String[] words) {
        int answer = 0;
        Trie root = new Trie('*');

        for(String word : words) {
            Trie parent = root;
            for(char c : word.toCharArray()) {
                parent.putChild(c);
                parent = parent.getChild(c);
            }
        }

        for(String word : words) {
            Trie parent = root;
            for(char c : word.toCharArray()) {
                answer++;
                int num = parent.getNumOfChildren(c);
                if(num == 1)
                    break;
                else {
                    parent = parent.getChild(c);
                }
            }
        }

        return answer;
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Character, Integer> numOfChildren;

        public Trie(char c) {
            this.c = c;
            children = new HashMap<>();
            numOfChildren = new HashMap<>();
        }

        void putChild(char c) {
            if(children.get(c) == null) {
                children.put(c, new Trie(c));
                numOfChildren.put(c, 1);
            } else {
                numOfChildren.put(c, numOfChildren.get(c) + 1);
            }
        }

        Trie getChild(char c) {
            return children.get(c);
        }

        int getNumOfChildren(char c) {
            return numOfChildren.get(c);
        }
    }
}
