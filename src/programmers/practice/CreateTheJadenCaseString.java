package programmers.practice;

public class CreateTheJadenCaseString {
    public static void main(String[] args) {
        String[] S = {
                "3 people    znFollowed me",
                "for the last week"
        };
        for(String s : S)
            System.out.println(new CreateTheJadenCaseString().solution(s));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] letters = s.toLowerCase().toCharArray();
        char prev = ' ';
        for(char letter : letters) {
            if(prev == ' ' && letter >= 'a' && letter <= 'z')
                answer.append((char) ('A' + letter - 'a'));
            else
                answer.append(letter);
            prev = letter;
        }

        return answer.toString();
    }
}
