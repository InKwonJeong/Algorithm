package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class JustThatSong {
    public static void main(String[] args) {
        String[] m = {
                "ABCDEFG",
                "CC#BCC#BCC#BCC#B",
                "ABC"
        };
        String[][] musicinfos = {
                {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:07,WORLD,ABCDEFG#"},
                {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}
        };
        for(int i = 0; i < m.length; i++)
            System.out.println(new JustThatSong().solution(m[i], musicinfos[i]));
    }

    public String solution(String m, String[] musicinfos) {
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");

        Music[] musics = new Music[musicinfos.length];
        for(int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            String[] start_time = infos[0].split(":");
            String[] end_time = infos[1].split(":");
            int start_hour = Integer.parseInt(start_time[0]);
            int start_minute = Integer.parseInt(start_time[1]);
            int end_hour = Integer.parseInt(end_time[0]);
            int end_minute = Integer.parseInt(end_time[1]);
            int play_time = getPlayTime(start_hour, start_minute, end_hour, end_minute);
            String melody = infos[3]
                    .replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
            musics[i] = new Music(i, play_time, infos[2], melody);
        }

        List<Music> list = new ArrayList<>();
        for(Music music : musics) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < music.play_time; i++) {
                builder.append(music.melody.charAt(i % music.melody.length()));
            }
            String melody = builder.toString();

            if(melody.contains(m))
                list.add(music);
        }

        list.sort(((o1, o2) -> {
            if(o1.play_time > o2.play_time)
                return -1;
            else if(o1.play_time < o2.play_time)
                return 1;
            else {
                return Integer.compare(o1.index, o2.index);
            }
        }));

        if(!list.isEmpty())
            return list.get(0).title;
        else
            return "(None)";
    }

    private int getPlayTime(int start_hour, int start_minute, int end_hour, int end_minute) {
        int start_time = start_hour * 60 + start_minute;
        int end_time = end_hour * 60 + end_minute;
        return end_time - start_time;
    }

    static class Music {
        int index, play_time;
        String title, melody;

        public Music(int index, int play_time, String title, String melody) {
            this.index = index;
            this.play_time = play_time;
            this.title = title;
            this.melody = melody;
        }
    }
}
