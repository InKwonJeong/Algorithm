package programmers.summerwintercoding2;

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
        char prev = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        int index = -1;
        for(int i = 1; i < words.length; i++) {
            if(prev != words[i].charAt(0) || set.contains(words[i])) {
                index = i;
                break;
            }
            set.add(words[i]);
            prev = words[i].charAt(words[i].length() - 1);
        }

        if(index == -1) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = index % n + 1;
            answer[1] = index / n + 1;
        }

        return answer;
    }
}
