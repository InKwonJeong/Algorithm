package programmers.kakao2;

import java.text.ParseException;
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
        int answer = 0;

        Traffic[] traffics = new Traffic[lines.length];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault());
        for(int i = 0; i < lines.length; i++) {
            String[] infos = lines[i].split(" ");
            try {
                long end = sdf.parse(infos[0] + " " + infos[1]).getTime();
                long process_time = (long) (Double.parseDouble(infos[2].replace("s", "")) * 1000) - 1;
                long start = end - process_time;
                traffics[i] = new Traffic(start, end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Arrays.sort(traffics, Comparator.comparingLong(o -> o.end));
        for(int i = 0; i < traffics.length; i++) {
            int count = 0;
            for(int j = i; j < traffics.length; j++) {
                if(traffics[i].end + 999 >= traffics[j].start)
                    count++;
            }

            if(answer < count)
                answer = count;
        }

        return answer;
    }

    static class Traffic {
        long start, end;

        public Traffic(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
