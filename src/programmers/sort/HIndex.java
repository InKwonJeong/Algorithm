package programmers.sort;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[][] citations = {
                {3, 0, 6, 1, 5},
                {5, 5, 5, 5}
        };
        for(int[] citation : citations)
            System.out.println(new HIndex().solution(citation));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = 0; i <= citations.length; i++) {
            int count = 0;
            for(int j = 0; j < citations.length; j++) {
                if(i <= citations[j]) {
                    count = citations.length - j;
                    break;
                }
            }
            if(i <= count)
                answer = i;
        }

        return answer;
    }
}
