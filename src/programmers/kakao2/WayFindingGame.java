package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WayFindingGame {
    public static void main(String[] args) {
        int[][][] nodeinfos = {
                {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}
        };
        for(int[][] nodeinfo : nodeinfos)
            System.out.println(Arrays.deepToString(new WayFindingGame().solution(nodeinfo)));
    }

    private List<Integer> preorder, postorder;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++)
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));

        nodes.sort((o1, o2) -> Integer.compare(o2.y, o1.y));
        Node root = makeTree(nodes);

        preorder(root);
        postorder(root);

        for(int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }

        return answer;
    }

    private void preorder(Node root) {
        preorder.add(root.n);
        if(root.left != null)
            preorder(root.left);
        if(root.right != null)
            preorder(root.right);
    }

    private void postorder(Node root) {
        if(root.left != null)
            postorder(root.left);
        if(root.right != null)
            postorder(root.right);
        postorder.add(root.n);
    }

    private Node makeTree(List<Node> nodes) {
        Node root = nodes.get(0);
        if(nodes.size() == 1)
            return root;

        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();
        for(Node node : nodes) {
            if(root.x > node.x)
                left.add(node);
            else if(root.x < node.x)
                right.add(node);
        }

        if(!left.isEmpty())
            root.left = makeTree(left);

        if(!right.isEmpty())
            root.right = makeTree(right);

        return root;
    }

    static class Node {
        int n, x, y;
        Node left, right;

        public Node(int n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }
}
