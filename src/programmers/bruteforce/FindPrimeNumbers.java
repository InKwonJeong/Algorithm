package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumbers {
    public static void main(String[] args) {
        String[] numbers = {"17", "011"};
        for (String number : numbers)
            System.out.println(new FindPrimeNumbers().solution(number));
    }

    private int n, answer;
    private String numbers;
    private Set<Integer> prime_numbers;
    private boolean[] visit;

    public int solution(String numbers) {
        this.numbers = numbers;
        prime_numbers = new HashSet<>();
        visit = new boolean[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++) {
            n = i;
            permutation(0, "");
        }

        return answer;
    }

    private void permutation(int depth, String num) {
        if(depth == n) {
            int number = Integer.parseInt(num);
            if(!prime_numbers.contains(number) && isPrimeNumber(number)) {
                prime_numbers.add(number);
                answer++;
            }
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                permutation(depth + 1, num + numbers.charAt(i));
                visit[i] = false;
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if(number <= 1)
            return false;

        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
