package programmers.kakao;

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
        Trie root = new Trie('*');
        for(String word : words) {
            Trie parent = root;
            for(int i = 0; i < word.length(); i++) {
                parent.putChild(word.charAt(i));
                parent = parent.getChild(word.charAt(i));
            }
        }

        int answer = 0;
        for(String word : words) {
            Trie parent = root;
            for(int i = 0; i < word.length(); i++) {
                answer++;
                Trie child = parent.getChild(word.charAt(i));
                if(child.num == 1)
                    break;
                else
                    parent = child;
            }
        }

        return answer;
    }

    static class Trie {
        char c;
        int num;
        HashMap<Character, Trie> children;

        public Trie(char c) {
            this.c = c;
            num = 0;
            children = new HashMap<>();
        }

        public void putChild(char c) {
            if(children.get(c) == null)
                children.put(c, new Trie(c));
            children.get(c).num++;
        }

        public Trie getChild(char c) {
            if(children.get(c) == null)
                putChild(c);

            return children.get(c);
        }
    }
}
