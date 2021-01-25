package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Meeting[] d = new Meeting[n];
        for(int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            d[i] = new Meeting(start, end);
        }

        Arrays.sort(d, (o1, o2) -> {
            if(o1.end > o2.end)
                return 1;
            else if(o1.end < o2.end)
                return -1;
            else {
                return Long.compare(o1.start, o2.start);
            }
        });

        long end = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(d[i].start >= end) {
                answer++;
                end = d[i].end;
            }
        }
        System.out.println(answer);
    }

    static class Meeting {
        long start, end;

        Meeting(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
