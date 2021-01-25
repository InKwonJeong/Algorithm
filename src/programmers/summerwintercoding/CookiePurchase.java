package programmers.summerwintercoding;

public class CookiePurchase {
    public static void main(String[] args) {
        int[][] cookies = {
                {1, 1, 2, 3},
                {1, 2, 4, 5}
        };
        for(int[] cookie : cookies)
            System.out.println(new CookiePurchase().solution(cookie));
    }

    public int solution(int[] cookie) {
        int answer = 0;
        int N = cookie.length;

        int[] d = new int[N + 1];
        for(int i = 0; i < N; i++)
            d[i + 1] += d[i] + cookie[i];

        for(int m = 1; m < N; m++) {
            for(int i = 0; i < m; i++) {
                int one = d[m] - d[i];
                if(one < answer)
                    continue;
                for(int j = N; j > m; j--) {
                    int two = d[j] - d[m];
                    if(one == two && answer < one)
                        answer = one;
                    else if(one > two)
                        break;
                }
            }
        }

        return answer;
    }
}
