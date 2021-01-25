package baekjoon.stage.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TourOfTree {

    private static int n;
    private static String[] inorder, postorder;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        inorder = br.readLine().split(" ");
        postorder = br.readLine().split(" ");

        Node root = getRoot(0, n - 1, 0, n - 1);
        System.out.println(builder);
    }

    private static Node getRoot(int in_start, int in_end, int post_start, int post_end) {
        if(in_start > in_end)
            return null;

        Node root = new Node(postorder[post_end]);
        builder.append(root.index).append(" ");
        for(int i = in_start; i <= in_end; i++) {
            if(postorder[post_end].equals(inorder[i])) {
                int diff = i - in_start;
                Node left = getRoot(in_start, i - 1, post_start, post_start + diff - 1);
                Node right = getRoot(i + 1, in_end, post_start + diff, post_end - 1);
                root.left = left;
                root.right = right;
                break;
            }
        }
        return root;
    }

    static class Node {
        String index;
        Node left, right;

        public Node(String index) {
            this.index = index;
        }
    }
}
