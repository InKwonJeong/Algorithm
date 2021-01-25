package codingtest.devmatching;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        String[][] moves = {
                {"U", "R", "D", "L", "U", "R", "D", "L"},
                {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"},
                {"U", "L", "D", "R", "R", "D", "D", "L", "U", "U"}
        };
        for(String[] move : moves)
            System.out.println(new Problem1().solution(move));
    }


    public int solution(String[] moves) {
        int answer = 0;

        boolean[][][] graph = new boolean[1001][1001][4];
        int row = 500;
        int column = 500;

        for(String move : moves) {
            if ("U".equals(move)) {
                graph[row][column][0] = true;
                graph[row - 1][column][1] = true;
                row--;
            } else if ("D".equals(move)) {
                graph[row][column][1] = true;
                graph[row + 1][column][0] = true;
                row++;
            } else if ("R".equals(move)) {
                graph[row][column][2] = true;
                graph[row][column + 1][3] = true;
                column++;
            } else {
                graph[row][column][3] = true;
                graph[row][column - 1][2] = true;
                column--;
            }
        }

        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(graph[i][j][2] && graph[i][j + 1][1] && graph[i + 1][j + 1][3] && graph[i + 1][j][0])
                    answer++;
            }
        }

        return answer;
    }
}
