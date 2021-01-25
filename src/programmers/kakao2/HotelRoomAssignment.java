package programmers.kakao2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HotelRoomAssignment {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1, 4};
        System.out.println(Arrays.toString(new HotelRoomAssignment().solution(k, room_number)));
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            List<Long> list = new ArrayList<>();
            long room = room_number[i];
            while (map.get(room) != null) {
                list.add(room);
                room = map.get(room);
            }

            answer[i] = room;
            map.put(room, room + 1);
            for(long num : list)
                map.put(num, room + 1);
        }

        return answer;
    }
}
