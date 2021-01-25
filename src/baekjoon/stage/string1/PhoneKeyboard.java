package baekjoon.stage.string1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PhoneKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            int n = Integer.parseInt(br.readLine());
            Trie root = new Trie('*', true);
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                words[i] = word;
                Trie parent = root;
                for(int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if(j == word.length() - 1)
                        parent.putChild(c, true);
                    else
                        parent.putChild(c, false);

                    parent = parent.getChild(c);
                }
            }

            double total = 0;
            for(String word : words)
                total += count(root, word);

            System.out.printf("%.2f\n", total / n);
        }
    }

    private static int count(Trie root, String word) {
        Trie parent = root;
        int count = 0;
        for(char c : word.toCharArray()) {
            if(parent.isLast || parent.getNumOfChild() != 1) {
                count++;
            }
            parent = parent.getChild(c);
        }
        return count;
    }

    static class Trie {
        char c;
        boolean isLast;
        HashMap<Character, Trie> children;

        public Trie(char c, boolean isLast) {
            this.c = c;
            this.isLast = isLast;
            children = new HashMap<>();
        }

        void putChild(char c, boolean isLast) {
            Trie child = children.get(c);
            if(child == null) {
                child = new Trie(c, isLast);
                children.put(c, child);
            } else if(isLast) {
                child.isLast = isLast;
            }
        }

        Trie getChild(char c) {
            return children.get(c);
        }

        int getNumOfChild() {
            return children.size();
        }
    }
}
