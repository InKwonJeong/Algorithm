package programmers.binarysearch;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] budgets = {9, 8, 5, 6, 7};
        int M = 5;
        System.out.println(new Budget().solution(budgets, M));
    }

    private int M;
    private int[] budgets;

    public int solution(int[] budgets, int M) {
        this.M = M;
        this.budgets = budgets;
        int answer = 0;

        Arrays.sort(budgets);
        int start = 0;
        int end = budgets[budgets.length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            boolean check = isAllocatable(mid);
            if(check) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private boolean isAllocatable(int max) {
        int total = 0;
        for(int budget : budgets) {
            if(budget > max)
                total += max;
            else
                total += budget;
        }
        return M >= total;
    }
}
