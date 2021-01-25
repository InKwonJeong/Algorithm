package baekjoon.stage.string1;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneNumberList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t --> 0) {
            boolean finish = true;
            int n = input.nextInt();
            String[] numbers = new String[n];
            for(int i = 0; i < n; i++)
                numbers[i] = input.next();

            Trie root = new Trie('*');
            for(String number : numbers) {
                Trie parent = root;
                for(char c : number.toCharArray()) {
                    parent.putChild(c);
                    parent = parent.getChild(c);
                }
            }

            for(String number : numbers) {
                Trie parent = root;
                for(char c : number.toCharArray()) {
                    parent = parent.getChild(c);
                }

                if(!parent.isEmpty()) {
                    finish = false;
                    break;
                }
            }

            if(finish)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;

        public Trie(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public void putChild(char c) {
            if(getChild(c) == null) {
                children.put(c, new Trie(c));
            }
        }

        public Trie getChild(char c) {
            return children.get(c);
        }

        public boolean isEmpty() {
            return children.isEmpty();
        }
    }
}
