package programmers.summerwintercoding;

public class InstallBaseStation {
    public static void main(String[] args) {
        int[] n = {11, 16, 4};
        int[][] stations = {
                {4, 11},
                {9},
                {2}
        };
        int[] w = {1, 2, 1};
        for(int i = 0; i < n.length; i++)
            System.out.println(new InstallBaseStation().solution(n[i], stations[i], w[i]));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int finish = 0;
        int W = 2 * w + 1;
        for(int station : stations) {
            int start = station - w;
            if(start < 1)
                start = 1;
            int end = station + w;
            if(end > n)
                end = n;

            if(start > finish) {
                int d = start - finish - 1;
                if (d % W == 0)
                    answer += d / W;
                else
                    answer += (d / W) + 1;
            }
            finish = end;
        }

        if(finish != n) {
            int d = n - finish;
            if(d % W == 0)
                answer += d / W;
            else
                answer += (d / W) + 1;
        }

        return answer;
    }

}
