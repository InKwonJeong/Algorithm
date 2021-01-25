package programmers.kakao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ThanksgivingTraffic {
    public static void main(String[] args) {
        String[][] lines = {
                {"2016-09-15 00:00:00.000 3s"},
                {"2016-09-15 23:59:59.999 0.001s"},
                {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"},
                {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"},
                {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"},
                {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"}
        };
        for(String[] line : lines)
            System.out.println(new ThanksgivingTraffic().solution(line));
    }

    public int solution(String[] lines) {
        Process[] processes = new Process[lines.length];

        for(int i = 0; i < lines.length; i++)
            processes[i] = makeProcess(lines[i]);

        Arrays.sort(processes, Comparator.comparingLong(o -> o.end));

        int answer = 0;
        for(int i = 0; i < processes.length; i++) {
            int count = 1;
            long end_time = processes[i].end + 999;
            for(int j = i + 1; j < processes.length; j++) {
                if(end_time >= processes[j].start)
                    count++;
            }
            if(answer < count)
                answer = count;
        }

        return answer;
    }

    private Process makeProcess(String line) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault());

        String[] log = line.split(" ");
        long process_time =
                (long) (Double.parseDouble(log[2].replace("s", "")) * 1000);
        try {
            long end = sdf.parse(log[0] + " " + log[1]).getTime();
            long start = end - process_time + 1;
            return new Process(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static class Process {
        long start, end;

        public Process(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
