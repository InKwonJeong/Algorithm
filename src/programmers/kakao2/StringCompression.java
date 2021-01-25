package programmers.kakao2;

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
        for(int i = 1; i <= s.length() / 2; i++) {
            String sub1 = s.substring(0, i);
            int count = 1;
            int length = s.length();
            for(int j = i; j <= s.length() - i; j += i) {
                String sub2 = s.substring(j, j + i);
                if(sub1.equals(sub2)) {
                    count++;
                } else {
                    if(count > 1) {
                        length -= (count - 1) * i;
                        while (count > 0) {
                            length++;
                            count /= 10;
                        }
                    }

                    sub1 = sub2;
                    count = 1;
                }
            }

            if(count > 1) {
                length -= (count - 1) * i;
                while (count > 0) {
                    length++;
                    count /= 10;
                }
            }

            if(answer > length)
                answer = length;
        }

        return answer;
    }
}
