package programmers.practice;

public class NumberOf124Country {
    public static void main(String[] args) {
        int[] N = {1, 2, 3, 4, 10, 15};
        for(int n : N)
            System.out.println(new NumberOf124Country().solution(n));
    }

    private int[] num = {1, 2, 4};
    public String solution(int n) {

        return convert(n);
    }

    private String convert(int n) {
        int q = (n - 1) / 3;
        int r = (n - 1) % 3;

        if(q == 0)
            return String.valueOf(num[r]);

        return convert(q) + num[r];
    }
}
