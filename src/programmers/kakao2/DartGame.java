package programmers.kakao2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame {
    public static void main(String[] args) {
        String[] dartResults = {
                "1S2D*3T",
                "1D2S#10S",
                "1D2S0T",
                "1S*2T*3S",
                "1D#2S*3S",
                "1T2D3D#",
                "1D2S3T*"
        };
        for (String dartResult : dartResults)
            System.out.println(new DartGame().solution(dartResult));
    }

    public int solution(String dartResult) {
        int answer = 0;
        Pattern pattern = Pattern.compile("[0-9]{1,2}[SDT][*#]?");
        Matcher matcher = pattern.matcher(dartResult);

        int[] points = new int[3];
        int index = 0;
        while (matcher.find()) {
            String round = matcher.group();
            Matcher number_matcher = Pattern.compile("[0-9]{1,2}").matcher(round);
            Matcher bonus_matcher = Pattern.compile("[SDT]").matcher(round);
            Matcher option_matcher = Pattern.compile("[*#]").matcher(round);

            int number = 0;
            int bonus = 0;
            String option = "";
            if(number_matcher.find())
                number = Integer.parseInt(number_matcher.group());
            if(bonus_matcher.find()) {
                String str = bonus_matcher.group();
                if(str.equals("S")) {
                    bonus = 1;
                } else if(str.equals("D")) {
                    bonus = 2;
                } else {
                    bonus = 3;
                }
            }
            if(option_matcher.find())
                option = option_matcher.group();

            if(option.equals("*")) {
                if(index != 0) {
                    points[index - 1] *= 2;
                }
                points[index] = 2 * (int) Math.pow(number, bonus);
            } else if(option.equals("#")) {
                points[index] = (-1) * (int) Math.pow(number, bonus);
            } else {
                points[index] = (int) Math.pow(number, bonus);
            }

            index++;
        }

        for(int point : points)
            answer += point;

        return answer;
    }
}
