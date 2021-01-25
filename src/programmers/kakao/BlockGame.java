package programmers.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BlockGame {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 8, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 8, 8, 8, 0},
                {7, 0, 0, 9, 0, 0, 0, 0, 0, 0},
                {7, 9, 9, 9, 0, 0, 0, 0, 0, 0},
                {7, 7, 6, 0, 0, 0, 4, 0, 0, 0},
                {6, 6, 6, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}
        };
//        int[][] board = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
//                {0, 0, 0, 2, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 2, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        };
        System.out.println(new BlockGame().solution(board));
    }

    private HashMap<Integer, Block> blocks;
    private Set<Integer> remove_blocks;
    private int[][] board;

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;

        this.board = board;
        remove_blocks = new HashSet<>();
        blocks = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    Block block = blocks.get(board[i][j]);
                    if (block == null) {
                        block = new Block(board[i][j]);
                        block.x.add(j);
                        block.y.add(i);
                        blocks.put(board[i][j], block);
                    } else {
                        block.x.add(j);
                        block.y.add(i);
                    }
                }
            }
        }

        Set<Integer> visit_blocks = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit_blocks.contains(board[i][j]) && board[i][j] != 0) {
                    if (removeBlock(blocks.get(board[i][j])))
                        answer++;
                    visit_blocks.add(board[i][j]);
                }
            }
        }

        System.out.println(remove_blocks);

        return answer;
    }

    private boolean removeBlock(Block block) {
        int bottom = 0;
        int top = Integer.MAX_VALUE;
        for (int y : block.y) {
            if (bottom < y)
                bottom = y;
            if (top > y)
                top = y;
        }

        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int x : block.x) {
            if (end < x)
                end = x;
            if (start > x)
                start = x;
        }

        int type = block.type;

        for (int x = start; x <= end; x++) {
            if (board[bottom][x] != type)
                return false;

            if(board[top][x] == type)
                continue;

            for (int y = bottom - 1; y >= 0; y--) {
                if (!(board[y][x] == 0 || board[y][x] == type || remove_blocks.contains(board[y][x]))) {
                    if (!removeBlock(blocks.get(board[y][x])))
                        return false;
                }
            }
        }

        remove_blocks.add(type);

        return true;
    }

    static class Block {
        int type;
        Set<Integer> x;
        Set<Integer> y;

        Block(int type) {
            this.type = type;
            x = new HashSet<>();
            y = new HashSet<>();
        }

        @Override
        public String toString() {
            return "Block{" +
                    "type=" + type +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
