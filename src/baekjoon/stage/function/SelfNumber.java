package baekjoon.stage.function;

public class SelfNumber {
    public static void main(String[] args) {
        boolean[] self = new boolean[10001];
        for(int i = 1; i <= 10000; i++)
            selfNumber(i, self);

        for (int i = 1; i < self.length; i++) {
            if (!self[i])
                System.out.println(i);
        }
    }

    private static void selfNumber(int n, boolean[] self) {
        int m = n;
        while (n > 0) {
            m += n % 10;
            n /= 10;
        }

        if(m <= 10000) {
            self[m] = true;
            selfNumber(m, self);
        }
    }
}
