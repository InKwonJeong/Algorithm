package programmers.practice;

public class LongestPalindrome {
    public static void main(String[] args) {
        String[] S = {
                "abcdcba",
                "abacde"
        };
        for(String s : S)
            System.out.println(new LongestPalindrome().solution(s));
    }

    private String s;
    public int solution(String s) {
        this.s = s;
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(check(j, j + s.length() - 1 - i)) {
                    return s.length() - i;
                }
            }
        }

        return answer;
    }

    private boolean check(int start, int end) {
        for(int i = 0; i <= (end - start) / 2; i++) {
            if(s.charAt(start + i) != s.charAt(end - i))
                return false;
        }
        return true;
    }
}
