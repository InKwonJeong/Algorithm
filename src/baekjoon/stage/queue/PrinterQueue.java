package baekjoon.stage.queue;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int index = input.nextInt();

            Queue<Document> queue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                int priority = input.nextInt();
                queue.offer(new Document(i, priority));
                list.add(priority);
            }

            list.sort(Comparator.reverseOrder());

            int answer = 1;
            while (!queue.isEmpty()) {
                int priority = list.remove(0);
                Document document = queue.poll();
                while (priority != document.priority) {
                    queue.add(document);
                    document = queue.poll();
                }

                if(document.index == index) {
                    System.out.println(answer);
                    break;
                }

                answer++;
            }

            t--;
        }
    }

    static class Document {
        int index, priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
