package programmers.kakao;

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

        int prev = 0;
        int point = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);
            if (now >= '0' && now <= '9') {
                point *= 10;
                point += now - '0';
            } else if (now == '#') {
                point *= -1;
                answer += point;
                prev = point;
                point = 0;
            } else if (now == '*') {
                answer += prev;
                point *= 2;
                answer += point;
                prev = point;
                point = 0;
            } else {
                switch (now) {
                    case 'S':
                        point = (int) Math.pow(point, 1);
                        break;
                    case 'D':
                        point = (int) Math.pow(point, 2);
                        break;
                    case 'T':
                        point = (int) Math.pow(point, 3);
                        break;
                }
                if (i + 1 == dartResult.length()
                        || !(dartResult.charAt(i + 1) == '#' || dartResult.charAt(i + 1) == '*')) {
                    answer += point;
                    prev = point;
                    point = 0;
                }
            }
        }

        if (point != 0)
            answer += point;

        return answer;
    }
}
