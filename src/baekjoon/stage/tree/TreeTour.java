package baekjoon.stage.tree;

import java.util.Scanner;

public class TreeTour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++)
            nodes[i] = new Node((char) ('A' + i));

        for(int i = 0; i < n; i++) {
            char parent = input.next().charAt(0);
            char left = input.next().charAt(0);
            char right = input.next().charAt(0);

            Node node = nodes[parent - 'A'];
            if(left != '.')
                node.left = nodes[left - 'A'];
            if(right != '.')
                node.right = nodes[right - 'A'];
        }

        System.out.println(preorder(nodes[0]));
        System.out.println(inorder(nodes[0]));
        System.out.println(postorder(nodes[0]));
    }

    private static String preorder(Node root) {
        StringBuilder builder = new StringBuilder();
        builder.append(root.c);
        if(root.left != null)
            builder.append(preorder(root.left));
        if(root.right != null)
            builder.append(preorder(root.right));
        return builder.toString();
    }

    private static String inorder(Node root) {
        StringBuilder builder = new StringBuilder();
        if(root.left != null)
            builder.append(inorder(root.left));
        builder.append(root.c);
        if(root.right != null)
            builder.append(inorder(root.right));
        return builder.toString();
    }

    private static String postorder(Node root) {
        StringBuilder builder = new StringBuilder();
        if(root.left != null)
            builder.append(postorder(root.left));
        if(root.right != null)
            builder.append(postorder(root.right));
        builder.append(root.c);
        return builder.toString();
    }

    static class Node {
        char c;
        Node left, right;

        public Node(char c) {
            this.c = c;
        }
    }
}
