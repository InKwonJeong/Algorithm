package programmers.kakao;

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
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int position = moves[i] - 1;
            for(int j = 0; j < board.length; j++) {
                if(board[j][position] != 0) {
                    stack.push(board[j][position]);
                    board[j][position] = 0;
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
            if(stack.isEmpty())
                break;
            if(temp.peek().equals(stack.peek())) {
                stack.pop();
                temp.pop();
                answer += 2;
                while (!temp.isEmpty())
                    stack.push(temp.pop());
            }
        }

        return answer;
    }
}
