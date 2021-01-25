package programmers.summerwintercoding2;

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
        BaseStation[] baseStations = new BaseStation[stations.length];
        for(int i = 0; i < stations.length; i++) {
            if(stations[i] - w < 1) {
                baseStations[i] = new BaseStation(1, stations[i] + w);
            } else if(stations[i] + w > n) {
                baseStations[i] = new BaseStation(stations[i] - w, n);
            } else {
                baseStations[i] = new BaseStation(stations[i] - w, stations[i] + w);
            }
        }

        int point = 1;
        int scope = 2 * w + 1;
        for(BaseStation baseStation : baseStations) {
            if(baseStation.start - point > 0)
                answer += (baseStation.start - point - 1) / scope + 1;
            point = baseStation.end + 1;
        }

        if(n - point >= 0) {
            answer += (n - point) / scope + 1;
        }

        return answer;
    }

    static class BaseStation {
        int start, end;

        public BaseStation(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
