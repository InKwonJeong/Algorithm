package programmers.kakao2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortingFileNames {
    public static void main(String[] args) {
        String[][] files = {
                {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
                {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
        };
        for(String[] file : files)
            System.out.println(Arrays.toString(new SortingFileNames().solution(file)));
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] file_array = new File[files.length];
        for(int i = 0; i < files.length; i++) {
            Matcher head_matcher = Pattern.compile("[^0-9]+").matcher(files[i]);
            Matcher num_matcher = Pattern.compile("[0-9]+").matcher(files[i]);
            if(head_matcher.find() && num_matcher.find()) {
                file_array[i] =
                        new File(i, head_matcher.group(), Integer.parseInt(num_matcher.group()), files[i]);
            }
        }

        Arrays.sort(file_array, ((o1, o2) -> {
            if(o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) > 0)
                return 1;
            else if(o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) < 0)
                return -1;
            else {
                if(o1.num < o2.num)
                    return -1;
                else if(o1.num > o2.num)
                    return 1;
                else
                    return Integer.compare(o1.index, o2.index);
            }
        }));

        for(int i = 0; i < file_array.length; i++)
            answer[i] = file_array[i].name;

        return answer;
    }

    static class File {
        String head, name;
        int index, num;

        public File(int index, String head, int num, String name) {
            this.index = index;
            this.head = head;
            this.num = num;
            this.name = name;
        }
    }
}
