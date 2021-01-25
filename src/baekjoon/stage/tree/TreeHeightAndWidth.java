package baekjoon.stage.tree;

import java.util.*;

public class TreeHeightAndWidth {

    private static HashMap<Integer, List<Integer>> heights;
    private static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Node[] nodes = new Node[n + 1];
        heights = new HashMap<>();
        int[] count = new int[n + 1];

        for(int i = 1; i <= n; i++)
            nodes[i] = new Node(i);

        for(int i = 1; i <= n; i++) {
            int index = input.nextInt();
            int left = input.nextInt();
            int right = input.nextInt();

            if(left != -1) {
                nodes[index].left = nodes[left];
                count[left]++;
            }

            if(right != -1) {
                nodes[index].right = nodes[right];
                count[right]++;
            }
        }

        Node root = null;
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                root = nodes[i];
                break;
            }
        }

        setColumn(root, 1, 1);
        int max_value = 0;
        int max_level = 0;
        int level = 1;
        while (true) {
            List<Integer> columns = heights.get(level);
            if(columns == null)
                break;

            Collections.sort(columns);
            int diff = columns.get(columns.size() - 1) - columns.get(0) + 1;
            if(max_value < diff) {
                max_level = level;
                max_value = diff;
            }

            level++;
        }

        System.out.printf("%d %d\n", max_level, max_value);
    }

    private static int getNumberOfTree(Node root) {
        int count = 1;
        if(root.left != null)
            count += getNumberOfTree(root.left);

        if(root.right != null)
            count += getNumberOfTree(root.right);

        return count;
    }

    private static void setColumn(Node root, int index, int level) {
        int number = 0;
        if(root.left != null) {
            number = getNumberOfTree(root.left);
            setColumn(root.left, index, level + 1);
        }

        List<Integer> columns = heights.get(level);
        if(columns == null) {
            columns = new ArrayList<>();
        }
        columns.add(index + number);
        heights.put(level, columns);

        if(root.right != null) {
            setColumn(root.right, index + number + 1, level + 1);
        }
    }

    static class Node {
        int index;
        Node left, right;

        public Node(int index) {
            this.index = index;
        }
    }
}
