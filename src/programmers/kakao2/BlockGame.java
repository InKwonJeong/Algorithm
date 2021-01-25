package programmers.kakao2;

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

    private int[][] board;
    private HashMap<Integer, Block> removableBlocks;
    private Set<Integer> removedBlocks;
    private Set<Integer> visit;

    public int solution(int[][] board) {
        this.board = board;
        removableBlocks = new HashMap<>();
        removedBlocks = new HashSet<>();
        visit = new HashSet<>();
        int answer = 0;

        for(int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board.length; j++) {
                if(!visit.contains(board[i][j])) {
                    visit.add(board[i][j]);
                    if(j + 2 < board.length && board[i][j] == board[i][j + 2]) {
                        removableBlocks.put(board[i][j], new Block(board[i][j], j, j + 2, i));
                    } else if(j + 1 < board.length && board[i][j] == board[i][j + 1]) {
                        removableBlocks.put(board[i][j], new Block(board[i][j], j, j + 1, i));
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != 0) {
                    Block block = removableBlocks.get(board[i][j]);
                    if(block != null)  {
                        if(!removedBlocks.contains(board[i][j])) {
                            if(removeBlock(block))
                                answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private boolean removeBlock(Block block) {
        for(int i = block.start; i <= block.end; i++) {
            if(board[block.bottom - 1][i] == block.n)
                continue;

            for(int j = block.bottom - 1; j >= 0; j--) {
                if(!(board[j][i] == 0 || removedBlocks.contains(board[j][i])))
                    return false;
            }
        }

        removedBlocks.add(block.n);
        return true;
    }

    static class Block {
        int n, start, end, bottom;
        boolean removed;

        public Block(int n, int start, int end, int bottom) {
            this.n = n;
            this.start = start;
            this.end = end;
            this.bottom = bottom;
        }
    }
}
