package programmers.kakao;

import java.util.*;

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
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();

        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        nodes.sort((o1, o2) -> {
            if (o1.y > o2.y)
                return -1;
            else if (o1.y < o2.y)
                return 1;
            else {
                return Integer.compare(o1.x, o2.x);
            }
        });

        setTree(nodes);
        preorder(nodes.get(0));
        postorder(nodes.get(0));

        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        return answer;
    }

    private void setTree(List<Node> nodes) {
        Node parent = nodes.get(0);

        List<Node> left_nodes = new ArrayList<>();
        List<Node> right_nodes = new ArrayList<>();
        for(Node node : nodes) {
            if(parent.x > node.x)
                left_nodes.add(node);
            else if(parent.x < node.x)
                right_nodes.add(node);
        }

        if(!left_nodes.isEmpty()) {
            parent.left = left_nodes.get(0);
            setTree(left_nodes);
        }
        if(!right_nodes.isEmpty()) {
            parent.right = right_nodes.get(0);
            setTree(right_nodes);
        }
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

    static class Node {
        int x, y, n;
        Node left, right;
        Node(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
}
