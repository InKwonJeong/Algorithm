package programmers.greedy;

import java.util.Arrays;

public class LifeBoat {
    public static void main(String[] args) {
        int[][] people = {
                {70, 50, 80, 50},
                {70, 80, 50},
                {10,20,30,40,50,60,70,80,90}
        };
        int[] limit = {100, 100, 100};
        for(int i = 0; i < people.length; i++)
            System.out.println(new LifeBoat().solution(people[i], limit[i]));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] visit = new boolean[people.length];
        Arrays.sort(people);

        int index = 0;
        for(int i = people.length - 1; i >= 0; i--) {
            if(!visit[i]) {
                visit[i] = true;
                answer++;
            } else
                break;

            if(people[i] + people[index] <= limit) {
                visit[index] = true;
                index++;
            }
        }

        return answer;
    }
}
