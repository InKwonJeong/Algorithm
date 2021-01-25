package programmers.kakao2;

import java.util.Stack;

public class CranePuppetGame {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(new CranePuppetGame().solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer>[] stack_list = new Stack[n];
        Stack<Integer> basket = new Stack<>();

        for(int i = 0; i < n; i++)
            stack_list[i] = new Stack<>();

        for(int j = 0; j < n; j++) {
            for(int i = n - 1; i >= 0; i--) {
                if(board[i][j] != 0)
                    stack_list[j].push(board[i][j]);
            }
        }

        for(int move : moves) {
            if(!stack_list[move - 1].isEmpty()) {
                int value = stack_list[move - 1].pop();
                if(basket.isEmpty()) {
                    basket.push(value);
                } else {
                    if(basket.peek() == value) {
                        basket.pop();
                        answer += 2;
                    }
                    else
                        basket.push(value);
                }
            }
        }

        return answer;
    }
}
