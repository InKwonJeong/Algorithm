package programmers.summerwintercoding2;

public class JumpAndTeleport {
    public static void main(String[] args) {
        int[] n = {5, 6, 5000};
        for(int i : n)
            System.out.println(new JumpAndTeleport().solution(i));
    }

    public int solution(int n) {
        return answer(n);
    }

    private int answer(int n) {
        if(n == 1)
            return 1;

        if(n % 2 == 0)
            return answer(n / 2);
        else
            return 1 + answer(n - 1);
    }
}
