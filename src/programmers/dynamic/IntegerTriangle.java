package programmers.dynamic;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new IntegerTriangle().solution(triangle));
    }

    public int solution(int[][] triangle) {
        int[][] d = new int[triangle.length + 1][triangle.length + 2];
        d[1][1] = triangle[0][0];
        for(int i = 2; i <= triangle.length; i++) {
            for(int j = 1; j <= i; j++) {
                if(d[i - 1][j - 1] > d[i - 1][j])
                    d[i][j] = d[i - 1][j - 1] + triangle[i - 1][j - 1];
                else
                    d[i][j] = d[i - 1][j] + triangle[i - 1][j - 1];
            }
        }
        int answer = 0;
        for(int i = 1; i <= triangle.length; i++) {
            if(answer < d[triangle.length][i])
                answer = d[triangle.length][i];
        }
        return answer;
    }
}
