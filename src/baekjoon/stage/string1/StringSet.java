package baekjoon.stage.string1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StringSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie root = new Trie('*', 0);
        while (n --> 0) {
            String word = br.readLine();
            Trie parent = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                parent.putChild(c, word.length());
                parent = parent.getChild(c);
            }
        }

        int answer = 0;
        while (m --> 0) {
            String word = br.readLine();
            if(find(root, word))
                answer++;
        }

        System.out.println(answer);
    }

    private static boolean find(Trie root, String word) {
        Trie parent = root;
        for(char c : word.toCharArray()) {
            Trie child = parent.getChild(c);
            if(child == null || child.getNumOfLength(word.length()) == 0)
                return false;
            else {
                parent = parent.getChild(c);
            }
        }

        return true;
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numOfLength;

        public Trie(char c, int length) {
            this.c = c;
            children = new HashMap<>();
            numOfLength = new HashMap<>();
        }

        void putChild(char c, int length) {
            Trie child = children.get(c);
            if(child == null) {
                child = new Trie(c, length);
                children.put(c, child);
            }
            child.putNumOfLength(length);
        }

        Trie getChild(char c) {
            return children.get(c);
        }

        void putNumOfLength(int length) {
            numOfLength.put(length, numOfLength.getOrDefault(length, 0) + 1);
        }

        int getNumOfLength(int length) {
            if(numOfLength.get(length) == null)
                return 0;
            else
                return numOfLength.get(length);
        }
    }
}
