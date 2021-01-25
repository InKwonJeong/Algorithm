package baekjoon.stage.tree;

import java.util.HashMap;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        int[] parents = new int[n];
        for(int i = 0; i < n; i++) {
            nodes.put(i, new TreeNode(i));
            parents[i] = input.nextInt();
        }

        TreeNode root = null;
        for(int i = 0; i < n; i++) {
            int parent = parents[i];
            if(parent == -1) {
                root = nodes.get(i);
                continue;
            }
            TreeNode node = nodes.get(parent);
            node.putChild(nodes.get(i));
        }

        int delete = input.nextInt();
        if(delete != root.index) {
            deleteNode(root, delete);
            System.out.println(getNumberOfLeaf(root));
        } else {
            System.out.println(0);
        }
    }

    private static int getNumberOfLeaf(TreeNode root) {
        if(root.getNumberOfChildren() == 0)
            return 1;
        else {
            int count = 0;
            for(TreeNode node : root.children.values())
                count += getNumberOfLeaf(node);
            return count;
        }
    }

    private static void deleteNode(TreeNode root, int index) {
        TreeNode child = root.getChild(index);
        if(child == null) {
            for(TreeNode node : root.children.values())
                deleteNode(node, index);
        } else {
            root.removeChild(index);
        }
    }

    static class TreeNode {
        int index;
        HashMap<Integer, TreeNode> children;

        public TreeNode(int index) {
            this.index = index;
            children = new HashMap<>();
        }

        public void putChild(TreeNode child) {
            children.put(child.index, child);
        }

        public TreeNode getChild(int index) {
            return children.get(index);
        }

        public void removeChild(int index) {
            children.remove(index);
        }

        public int getNumberOfChildren() {
            return children.size();
        }
    }
}
