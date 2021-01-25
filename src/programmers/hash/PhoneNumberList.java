package programmers.hash;

import java.util.HashMap;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[][] phone_book = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"12", "123", "1235", "567", "88"}
        };
        for(String[] phone : phone_book)
            System.out.println(new PhoneNumberList().solution(phone));
    }

    public boolean solution(String[] phone_book) {
        Trie root = new Trie('*');
        for(String phone : phone_book) {
            Trie parent = root;
            for(int i = 0; i < phone.length(); i++) {
                parent.putChild(phone.charAt(i));
                parent = parent.getChild(phone.charAt(i));
            }
        }

        for(String phone : phone_book) {
            Trie parent = root;
            for(int i = 0; i < phone.length(); i++) {
                parent = parent.getChild(phone.charAt(i));
            }

            if(parent.getNumOfChildren() != 0)
                return false;
        }

        return true;
    }

    static class Trie {
        char c;
        HashMap<Character, Trie> children;

        public Trie(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public int getNumOfChildren() {
            return children.size();
        }

        public void putChild(char c) {
            if(children.get(c) == null)
                children.put(c, new Trie(c));
        }

        public Trie getChild(char c) {
            if(children.get(c) == null)
                putChild(c);
            return children.get(c);
        }
    }
}
