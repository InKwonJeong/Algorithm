package programmers.summerwintercoding;

import java.util.Arrays;
import java.util.HashSet;

public class EnglishWordChain {
    public static void main(String[] args) {
        int[] n = {3, 5, 2};
        String[][] words = {
                {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
                {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
                {"hello", "one", "even", "never", "now", "world", "draw"}
        };
        for(int i = 0; i < n.length; i++)
            System.out.println(Arrays.toString(new EnglishWordChain().solution(n[i], words[i])));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();

        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) ||
                    words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            set.add(words[i]);
        }

        return answer;
    }
}
