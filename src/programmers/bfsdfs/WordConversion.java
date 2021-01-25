package programmers.bfsdfs;

public class WordConversion {
    public static void main(String[] args) {
        String[] begin = {"hit", "hit"};
        String[] target = {"cog", "cog"};
        String[][] words = {
                {"hot", "dot", "dog", "lot", "log", "cog"},
                {"hot", "dot", "dog", "lot", "log"}
        };
        for (int i = 0; i < begin.length; i++)
            System.out.println(new WordConversion().solution(begin[i], target[i], words[i]));
    }

    private int answer;
    private String target;
    private String[] words;
    private boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        visit = new boolean[words.length];

        dfs(0, begin);

        return answer;
    }

    private void dfs(int depth, String word) {
        if (word.equals(target)) {
            if (answer == 0 || answer > depth)
                answer = depth;
            return;
        }

        if (depth == words.length)
            return;

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && isConvertable(word, words[i])) {
                visit[i] = true;
                dfs(depth + 1, words[i]);
                visit[i] = false;
            }
        }
    }

    private boolean isConvertable(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++)
            if (word1.charAt(i) != word2.charAt(i))
                count++;
        return count == 1;
    }
}
