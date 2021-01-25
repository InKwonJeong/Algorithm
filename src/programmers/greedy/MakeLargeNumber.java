package programmers.greedy;

import java.util.HashSet;
import java.util.Set;

public class MakeLargeNumber {
    public static void main(String[] args) {
        String[] number = {"1924", "1231234", "4177252841"};
        int[] k = {2, 3, 4};
        for(int i = 0; i < number.length; i++)
            System.out.println(new MakeLargeNumber().solution(number[i], k[i]));
    }

    public String solution(String number, int k) {
        Set<Integer> remove_index = new HashSet<>();
        for(int i = 1; i < number.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(!remove_index.contains(j) && number.charAt(i) > number.charAt(j))
                    remove_index.add(j);
                else if(number.charAt(i) <= number.charAt(j))
                    break;

                if(remove_index.size() == k)
                    break;
            }
            if(remove_index.size() == k)
                break;
        }

        int left = k - remove_index.size();
        for(int i = 1; i <= left; i++)
            remove_index.add(number.length() - i);

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            if(!remove_index.contains(i))
                builder.append(number.charAt(i));
        }
        return builder.toString();
    }
}
