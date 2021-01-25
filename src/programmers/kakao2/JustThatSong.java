package programmers.kakao2;

import java.util.Arrays;

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
        String answer = null;
        Music[] musics = new Music[musicinfos.length];
        for(int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            musics[i] = new Music(i, infos[2], convert(infos[3]), calculateTime(infos[0], infos[1]));
        }

        Arrays.sort(musics, ((o1, o2) -> {
            if(o1.time > o2.time) {
                return -1;
            } else if(o1.time < o2.time) {
                return 1;
            } else {
                return Integer.compare(o1.index, o2.index);
            }
        }));

        m = convert(m);
        for(Music music : musics) {
            String melody = makeMelody(music.melody, music.time);
            if(melody.contains(m)) {
                answer = music.title;
                break;
            }
        }

        if(answer == null)
            return "(None)";
        else
            return answer;
    }

    private String makeMelody(String m, int time) {
        StringBuilder melody = new StringBuilder();
        for(int i = 0; i < time; i++) {
            melody.append(m.charAt(i % m.length()));
        }
        return melody.toString();
    }

    private String convert(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private int calculateTime(String a, String b) {
        String[] start = a.split(":");
        String[] end = b.split(":");

        int start_hour = Integer.parseInt(start[0]);
        int start_minute = Integer.parseInt(start[1]);;
        int end_hour = Integer.parseInt(end[0]);
        int end_minute = Integer.parseInt(end[1]);

        return (end_hour * 60 + end_minute) - (start_hour * 60 + start_minute);
    }

    static class Music {
        String title, melody;
        int index, time;

        public Music(int index, String title, String melody, int time) {
            this.index = index;
            this.title = title;
            this.melody = melody;
            this.time = time;
        }
    }
}
