package programmers.stackandqueue;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(new StockPrice().solution(prices)));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int count = 0;
            for(int j = i + 1; j < prices.length; j++) {
                count++;
                if(prices[i] > prices[j])
                    break;
            }
            answer[i] = count;
        }

        return answer;
    }
}
