package programmers.summerwintercoding;

public class JumpAndTeleport {
    public static void main(String[] args) {
        int[] n = {5, 6, 5000};
        for(int i : n)
            System.out.println(new JumpAndTeleport().solution(i));
    }

    public int solution(int n) {
        int ans = 0;
        while (n != 0) {
            if(n % 2 == 0)
                n /= 2;
            else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
