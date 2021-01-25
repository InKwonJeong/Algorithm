package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HotelRoomAssignment {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        System.out.println(Arrays.toString(new HotelRoomAssignment().solution(k, room_number)));
    }

    public long[] solution(long k, long[] room_number) {
        HashMap<Long, Long> map = new HashMap<>();
        long[] answer = new long[room_number.length];
        for(int i = 0; i < room_number.length; i++) {
            List<Long> list = new ArrayList<>();
            long n = room_number[i];
            while(map.get(n) != null) {
                list.add(n);
                n = map.get(n);
            }
            answer[i] = n;
            map.put(n, n + 1);
            for(long num : list)
                map.put(num, n + 1);
        }

        return answer;
    }
}
