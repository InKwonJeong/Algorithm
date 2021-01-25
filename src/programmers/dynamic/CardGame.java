package programmers.dynamic;

public class CardGame {
    public static void main(String[] args) {
        int[] left = {3, 2, 5};
        int[] right = {2, 4, 1};
        System.out.println(new CardGame().solution(left, right));
    }

    public int solution(int[] left, int[] right) {
        int[][] d = new int[left.length + 1][right.length + 1];

        for (int i = left.length - 1; i >= 0; i--) {
            for (int j = right.length - 1; j >= 0; j--) {
                if (left[i] > right[j]) d[i][j] = d[i][j + 1] + right[j];
                else d[i][j] = Math.max(d[i + 1][j], d[i + 1][j + 1]);
            }
        }
        return d[0][0];
    }

}
