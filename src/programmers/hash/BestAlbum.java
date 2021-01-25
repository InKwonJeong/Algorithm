package programmers.hash;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {
                "classic", "pop", "classic", "classic", "pop"
        };
        int[] play = {
                500, 600, 150, 800, 2500
        };
        System.out.println(Arrays.toString(new BestAlbum().solution(genres, play)));
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, List<Music>> musics = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            List<Music> musicList = musics.get(genres[i]);
            if(musicList == null) {
                musicList = new ArrayList<>();
                musicList.add(new Music(i, plays[i]));
                musics.put(genres[i], musicList);
            } else {
                musicList.add(new Music(i, plays[i]));
            }
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genre = new ArrayList<>();
        for(String key : count.keySet())
            genre.add(key);

        genre.sort((o1, o2) -> Integer.compare(count.get(o2), count.get(o1)));

        List<Integer> best_album = new ArrayList<>();
        for(String key : genre) {
            List<Music> musicList = musics.get(key);
            Collections.sort(musicList);
            best_album.add(musicList.get(0).index);
            if(musicList.size() > 1)
                best_album.add(musicList.get(1).index);
        }

        int[] answer = new int[best_album.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = best_album.get(i);
        return answer;
    }

    static class Music implements Comparable<Music> {
        int index, plays;

        public Music(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            if(plays > o.plays)
                return -1;
            else if(plays < o.plays)
                return 1;
            else
                return Integer.compare(index, o.index);
        }

        @Override
        public String toString() {
            return "Music{" +
                    "index=" + index +
                    ", plays=" + plays +
                    '}';
        }
    }

}
