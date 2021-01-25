package baekjoon.stage.function;

public class SumOfNIntegers {
    long sum(int[] a) {
        long sum = 0;
        for(int b : a)
            sum += b;
        return sum;
    }
}
