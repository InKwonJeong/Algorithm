package programmers.kakao2;

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
        String answer = "";
        Time[] crew_time = new Time[timetable.length];
        Time[] bus_time = new Time[n];

        for(int i = 0; i < timetable.length; i++) {
            String[] times = timetable[i].split(":");
            crew_time[i] = new Time(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
        }

        Arrays.sort(crew_time);

        bus_time[0] = new Time(9, 0);
        for(int i = 1; i < bus_time.length; i++)
            bus_time[i] = calculate(bus_time[i - 1], t);

        int index = 0;
        for(int i = 0; i < bus_time.length - 1; i++) {
            for(int j = 0; j < m; j++) {
                if(bus_time[i].compareTo(crew_time[index]) >= 0) {
                    index++;
                    if(index == crew_time.length)
                        return bus_time[bus_time.length - 1].toString();
                } else
                    break;
            }
        }

        int number = crew_time.length - index;
        if(number < m)
            return bus_time[bus_time.length - 1].toString();
        else {
            Time last_crew = crew_time[index + m - 1];
            if(bus_time[bus_time.length - 1].compareTo(last_crew) < 0) {
                return bus_time[bus_time.length - 1].toString();
            } else {
                return calculate(last_crew, -1).toString();
            }
        }
    }

    private Time calculate(Time time, int t) {
        int hour = time.hour;
        int minute = time.minute + t;

        if(minute >= 60) {
            hour++;
            minute -= 60;
        } else if(minute < 0) {
            minute += 60;
            hour--;
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
            return String.format("%02d:%02d", hour, minute);
        }

        @Override
        public int compareTo(Time o) {
            if(hour < o.hour)
                return -1;
            else if(hour > o.hour)
                return 1;
            else
                return Integer.compare(minute, o.minute);
        }
    }
}
