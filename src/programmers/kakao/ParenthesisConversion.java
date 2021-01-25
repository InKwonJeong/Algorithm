package programmers.kakao;

public class ParenthesisConversion {
    public static void main(String[] args) {
        String[] s = {
                "(()())()",
                ")(",
                "()))((()",
                ")()()()("
        };
        for (String p : s)
            System.out.println(new ParenthesisConversion().solution(p));
    }

    public String solution(String w) {
        StringBuilder answer = new StringBuilder();
        String u = "";
        String v = "";

        if (check(w) || w.equals(""))
            return w;

        int index = 0;
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(')
                count++;
            else
                count--;
            if (count == 0) {
                index = i + 1;
                break;
            }
        }

        u = w.substring(0, index);
        if (index < w.length())
            v = w.substring(index);

        if (check(u)) {
            answer.append(u);
            answer.append(solution(v));
        } else {
            answer.append('(');
            answer.append(solution(v));
            answer.append(')');
            answer.append(convert(u));
        }

        return answer.toString();
    }

    private boolean check(String u) {
        int count = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(')
                count++;
            else
                count--;
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    private String convert(String u) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                str.append(')');
            else
                str.append('(');
        }
        return str.toString();
    }
}
