package baekjoon.stage.string1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AntOyster {

    private static StringBuilder builder;

    public static void main(String[] args) {
        builder = new StringBuilder();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Trie root = new Trie("*", 0);
        while (n --> 0) {
            int k = input.nextInt();
            Trie parent = root;
            while (k --> 0) {
                String name = input.next();
                parent.putChild(name);
                parent = parent.getChild(name);
            }
        }

        print(root);
        System.out.println(builder);
    }

    private static void print(Trie root) {
        if(root.level != 0) {
            for (int i = 1; i < root.level; i++)
                builder.append("--");

            builder.append(root.name).append("\n");
        }

        String[] childrenNames = root.getChildren();
        for(String name : childrenNames) {
            print(root.getChild(name));
        }
    }

    static class Trie {
        String name;
        int level;
        HashMap<String, Trie> children;

        public Trie(String name, int level) {
            this.name = name;
            this.level = level;
            children = new HashMap<>();
        }

        void putChild(String name) {
            if(children.get(name) == null) {
                Trie child = new Trie(name, level + 1);
                children.put(name, child);
            }
        }

        Trie getChild(String name) {
            return children.get(name);
        }

        String[] getChildren() {
            String[] names = new String[children.size()];
            children.keySet().toArray(names);
            Arrays.sort(names);
            return names;
        }
    }
}
