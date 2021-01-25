package programmers.kakao;

public class StringCompression {
    public static void main(String[] args) {
        String[] s = {
                "a",
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        for (String value : s)
            System.out.println(new StringCompression().solution(value));
    }

    public int solution(String s) {
        int answer = s.length();
        int n = s.length() / 2;
        for(int i = 1; i <= n; i++) {
            int length = s.length();
            int count = 0;
            String sub = s.substring(0, i);
            for(int k = i; k <= s.length() - i; k+= i) {
                String temp = s.substring(k, k + i);
                if(sub.equals(temp))
                    count++;
                else {
                    if(count != 0) {
                        length -= i * count;
                        count++;
                        while (count > 0) {
                            length++;
                            count /= 10;
                        }
                    }
                    count = 0;
                    sub = temp;
                }
            }

            if(count != 0) {
                length -= i * count;
                count++;
                while (count > 0) {
                    length++;
                    count /= 10;
                }
            }

            System.out.printf("%d %d\n", i, length);

            if(answer > length)
                answer = length;
        }

        return answer;
    }

}
