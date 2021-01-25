package programmers.bfsdfs;

import java.util.Arrays;
import java.util.Comparator;

public class TravelRoute {
    public static void main(String[] args) {
        String[][][] tickets = {
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}
        };
        for(String[][] ticket : tickets)
            System.out.println(Arrays.toString(new TravelRoute().solution(ticket)));
    }

    private String[] answer, temp;
    private String[][] tickets;
    private boolean[] visit;
    private boolean finish;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));
        this.tickets = tickets;
        visit = new boolean[tickets.length];
        temp = new String[tickets.length + 1];

        temp[0] = "ICN";
        dfs(1, "ICN");

        return answer;
    }

    private void dfs(int depth, String city) {
        if(finish)
            return;

        if(depth == temp.length) {
            answer = temp.clone();
            finish = true;
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visit[i] && city.equals(tickets[i][0])) {
                visit[i] = true;
                temp[depth] = tickets[i][1];
                dfs(depth + 1, tickets[i][1]);
                visit[i] = false;
            }
        }
    }
}
