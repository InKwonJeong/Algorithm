package codingtest.kakao;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        String[][] gems = {
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
        };

        for(String[] gem : gems)
            System.out.println(Arrays.toString(new Problem3().solution(gem)));
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashMap<String, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            List<Integer> list = indexes.get(gem);
            if (indexes.get(gem) == null) {
                list = new ArrayList<>();
            }
            list.add(i + 1);
            indexes.put(gem, list);
        }

        int size = indexes.size();
        List<Section> sections = new ArrayList<>();
        List<Jewerly> jewerlyList = new ArrayList<>();

        for(String jewelry : indexes.keySet()) {
            int index = indexes.get(jewelry).remove(0);
            jewerlyList.add(new Jewerly(jewelry, index));
        }

        jewerlyList.sort(Comparator.comparingInt(o -> o.index));
        sections.add(new Section(jewerlyList.get(0).index, jewerlyList.get(size - 1).index));

        Jewerly jewerly = jewerlyList.remove(0);
        while (!indexes.get(jewerly.name).isEmpty()) {
            jewerlyList.add(new Jewerly(jewerly.name, indexes.get(jewerly.name).remove(0)));
            jewerlyList.sort(Comparator.comparingInt(o -> o.index));
            sections.add(new Section(jewerlyList.get(0).index, jewerlyList.get(size - 1).index));
            jewerly = jewerlyList.remove(0);
        }

        sections.sort(((o1, o2) -> {
            if(o1.distance < o2.distance)
                return  -1;
            else if(o1.distance > o2.distance)
                return 1;
            else
                return Integer.compare(o1.start, o2.start);
        }));

        answer[0] = sections.get(0).start;
        answer[1] = sections.get(0).end;
        return answer;
    }

    static class Jewerly {
        String name;
        int index;

        public Jewerly(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    static class Section {
        int start, end, distance;

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
            distance = end - start;
        }

        @Override
        public String toString() {
            return "Section{" +
                    "start=" + start +
                    ", end=" + end +
                    ", distance=" + distance +
                    '}';
        }
    }
}
