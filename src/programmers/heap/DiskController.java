package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {
                {0, 3}, {1, 9}, {500 , 6}
        };
        System.out.println(new DiskController().solution(jobs));
    }

    public int solution(int[][] jobs) {
        Queue<Job> job_queue = new PriorityQueue<>(((o1, o2) -> {
            if(o1.start > o2.start)
                return 1;
            else if(o1.start < o2.start)
                return -1;
            else
                return Integer.compare(o1.time, o2.time);
        }));

        for(int[] job : jobs)
            job_queue.add(new Job(job[0], job[1]));

        int time = job_queue.peek().start;
        int process_time = 0;

        Queue<Job> wait_queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        while (!job_queue.isEmpty() || !wait_queue.isEmpty()) {
            Job job;
            if(wait_queue.isEmpty())
                job = job_queue.poll();
            else
                job = wait_queue.poll();

            if(time < job.start)
                time = job.start + job.time;
            else
                time += job.time;

            while (!job_queue.isEmpty() && time >= job_queue.peek().start)
                wait_queue.add(job_queue.poll());

            process_time += time - job.start;
        }

        return process_time / jobs.length;
    }

    static class Job {
        int start, time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}
