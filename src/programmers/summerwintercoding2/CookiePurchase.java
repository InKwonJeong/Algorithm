package programmers.summerwintercoding2;

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
        int[] d = new int[cookie.length + 1];
        d[1] = cookie[0];
        for(int i = 2; i <= cookie.length; i++)
            d[i] = cookie[i - 1] + d[i - 1];

        for(int i = 1; i < cookie.length; i++) {
            for(int j = 0; j < i; j++) {
                for (int k = cookie.length; k >= i + 1; k--) {
                    int basket1 = d[i] - d[j];
                    int basket2 = d[k] - d[i];
                    if(answer > basket1)
                        break;
                    if(basket1 == basket2) {
                        answer = basket1;
                    } else if(basket1 > basket2)
                        break;
                }
            }
        }

        return answer;
    }
}
