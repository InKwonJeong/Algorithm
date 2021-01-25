package programmers.kakao;

import java.util.Arrays;

public class ShuttleBus {
    public static void main(String[] args) {
        int[] n = {1, 2, 2, 1, 1, 10};
        int[] t = {1, 10, 1, 1, 1, 60};
        int[] m = {5, 2, 2, 5, 1, 45};
        String[][] timetable = {
                {"08:00", "08:01", "08:02", "08:03"},
                {"09:10", "09:09", "08:00"},
                {"09:00", "09:00", "09:00", "09:00"},
                {"00:01", "00:01", "00:01", "00:01", "00:01"},
                {"23:59"},
                {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
        };
        for(int i = 0; i < n.length; i++) {
            System.out.println(new ShuttleBus().solution(n[i], t[i], m[i], timetable[i]));
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        Time[] crew_time = new Time[timetable.length];
        Time[] bus_time = new Time[n];

        bus_time[0] = new Time(9, 0);
        for(int i = 1; i < bus_time.length; i++)
            bus_time[i] = plus(bus_time[i - 1], t);

        for(int i = 0; i < crew_time.length; i++) {
            String[] times = timetable[i].split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            crew_time[i] = new Time(hour, minute);
        }

        Arrays.sort(crew_time);

        int crew_num = 0;
        for(int i = 0; i < n - 1; i++) {
            Time bus = bus_time[i];
            for(int j = 0; j < m; j++) {
                if(bus.compareTo(crew_time[crew_num]) >= 0)
                    crew_num++;
                else
                    break;
            }
        }

        Time last_bus = bus_time[n - 1];
        if(m > crew_time.length - crew_num)
            return String.format("%02d:%02d", last_bus.hour, last_bus.minute);
        else {
            Time last_crew = crew_time[crew_num + m - 1];
            if(last_bus.compareTo(last_crew) < 0)
                return String.format("%02d:%02d", last_bus.hour, last_bus.minute);
            else {
                Time arrive_time = minus(last_crew, 1);
                return String.format("%02d:%02d", arrive_time.hour, arrive_time.minute);
            }
        }
    }

    private Time plus(Time time, int m) {
        int hour = time.hour;
        int minute = time.minute;

        minute += m;
        if(minute >= 60) {
            hour++;
            minute -= 60;
        }
        return new Time(hour, minute);
    }

    Time minus(Time time, int m) {
        int hour = time.hour;
        int minute = time.minute;

        minute -= m;
        if(minute < 0) {
            hour--;
            minute += 60;
        }
        return new Time(hour, minute);
    }

    static class Time implements Comparable<Time> {
        int hour, minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", minute=" + minute +
                    '}';
        }

        @Override
        public int compareTo(Time o) {
            if(hour > o.hour)
                return 1;
            else if(hour < o.hour)
                return -1;
            else {
                return Integer.compare(minute, o.minute);
            }
        }
    }
}
