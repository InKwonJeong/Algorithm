package programmers.kakao;

import java.util.Arrays;

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
        File[] file_array = new File[files.length];
        for(int i = 0; i < files.length; i++) {
            String file = files[i];
            int start = 0, end = 0;
            for(int j = 0; j < file.length(); j++) {
                if(isNum(file.charAt(j))) {
                    if(start == 0)
                        start = j;
                    if(start != 0 && (j + 1 == file.length() || !isNum(file.charAt(j + 1)))) {
                        end = j + 1;
                        break;
                    }
                }
            }
            String head = file.substring(0, start);
            String index = file.substring(start, end);
            String tail = file.substring(end);
            file_array[i] = new File(head, index, tail);
        }

        Arrays.sort(file_array, ((o1, o2) -> {
            String head1 = o1.head.toLowerCase();
            String head2 = o2.head.toLowerCase();
            int index1 = Integer.parseInt(o1.index);
            int index2 = Integer.parseInt(o2.index);

            if(head1.compareTo(head2) > 0)
                return 1;
            else if(head1.compareTo(head2) < 0)
                return -1;
            else {
                return Integer.compare(index1, index2);
            }
        }));

        String[] answer = new String[file_array.length];
        for(int i = 0; i < file_array.length; i++)
            answer[i] = file_array[i].head + file_array[i].index + file_array[i].tail;

        return answer;
    }

    private boolean isNum(char c) {
        if(c >= '0' && c <= '9')
            return true;
        else
            return false;
    }

    static class File {
        String head, index, tail;

        public File(String head, String index, String tail) {
            this.head = head;
            this.index = index;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return "File{" +
                    "head='" + head + '\'' +
                    ", index='" + index + '\'' +
                    ", tail='" + tail + '\'' +
                    '}';
        }
    }
}
