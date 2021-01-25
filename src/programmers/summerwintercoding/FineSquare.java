package programmers.summerwintercoding;

public class FineSquare {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(new FineSquare().solution(w, h));
    }

    public long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++) {
            answer += ((long) h * i) / (long) w;
        }
        return answer * 2;
    }
}
