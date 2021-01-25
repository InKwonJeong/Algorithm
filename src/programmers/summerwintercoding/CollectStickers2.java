package programmers.summerwintercoding;

public class CollectStickers2 {
    public static void main(String[] args) {
        int[][] stickers = {
                {14, 6, 5, 11, 3, 9, 2, 10},
                {1, 3, 2, 5, 4}
        };
        for(int[] sticker : stickers)
            System.out.println(new CollectStickers2().solution(sticker));
    }

    public int solution(int[] sticker) {
        int answer = 0;
        int[] d1 = new int[sticker.length];
        int[] d2 = new int[sticker.length];

        if(sticker.length == 1)
            return sticker[0];

        d1[0] = sticker[0];
        d1[1] = sticker[0];
        d2[0] = 0;
        d2[1] = sticker[1];

        for(int i = 2; i < sticker.length; i++) {
            d1[i] = Math.max(d1[i - 2] + sticker[i], d1[i - 1]);
            d2[i] = Math.max(d2[i - 2] + sticker[i], d2[i - 1]);
        }

        return Math.max(d1[sticker.length - 2], d2[sticker.length - 1]);
    }
}
