package baekjoon.stage.backtracking;

import java.util.Scanner;

public class InsertOperator {

    static int[] numbers;// 숫자 배열
    static int[] operators;// 연산자 횟수를 저장할 배열
    static int n, max, min;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        numbers = new int[n];
        operators = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = input.nextInt();
        }

        DFS(1, numbers[0]); // 출발 시작
        System.out.println(max);
        System.out.println(min);
    }

    // x는 다음 숫자이고 sum은 그곳까지 갔을 때 합 이다.
    static void DFS(int depth, int sum) {
        // ('+', '-', '*', '/') 연산자들을 한번씩 다 확인해야함 (DFS 전체탐색이니깐)
        for (int i = 0; i < 4; i++) {
            // 각각의 연산자마다 개수를 둬서 모두 0이면 쓸 연산자가 없으므로 통과
            if (operators[i] != 0) {
                operators[i]--; // 사용된 연산자를 하나씩 뺀다.
                switch (i) {
                    case 0:
                        DFS(depth + 1, sum + numbers[depth]); // 다음 숫자 계산해야되니깐
                        break;
                    case 1:
                        DFS(depth + 1, sum - numbers[depth]); // 다음 숫자 계산해야되니깐
                        break;
                    case 2:
                        DFS(depth + 1, sum * numbers[depth]); // 다음 숫자 계산해야되니깐
                        break;
                    case 3:
                        DFS(depth + 1, sum / numbers[depth]); // 다음 숫자 계산해야되니깐
                        break;
                }
                operators[i]++; // 사용이 끝났으면 다시 추가해준다.
            }
        }

        // 카운트가 입력값과 같아질 때 출력 (모든 숫자를 다 사용했을 경우)
        if (depth == n) {
            if (sum > max)
                max = sum;
            if (sum < min)
                min = sum;
        }
    }
}
