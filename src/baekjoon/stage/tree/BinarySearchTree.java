package baekjoon.stage.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchTree {

    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node root = new Node(Integer.parseInt(st.nextToken()));

        while (br.ready()) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            addTree(root, index);
        }

        builder = new StringBuilder();

        postorder(root);
        System.out.println(builder);
    }

    private static void postorder(Node root) {
        if(root.left != null)
            postorder(root.left);
        if(root.right != null)
            postorder(root.right);
        builder.append(root.index).append("\n");
    }

    private static Node addTree(Node root, int index) {
        if(root == null)
            return new Node(index);
        if(root.index > index)
            root.left = addTree(root.left, index);
        else
            root.right = addTree(root.right, index);
        return root;
    }

    static class Node {
        int index;
        Node left, right;

        public Node(int index) {
            this.index = index;
        }
    }
}
