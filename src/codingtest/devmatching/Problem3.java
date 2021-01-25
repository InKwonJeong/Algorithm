package codingtest.devmatching;

public class Problem3 {
    public static void main(String[] args) {
        String[] commands = {
                "<v>AB^CYv^XAZ",
                "ABCXYZ",
                "ABCXYZ"
        };

        String[][] buttons = {
                {"v>AB^CYv^XA", "<v>A", "^XAZ", "Yv^XA", ">AB^"},
                {"BCXY"},
                {"CXYZ", "AB"}
        };

        int[][] scores = {
                {50, 18, 20, 30, 25},
                {2},
                {2, 3}
        };

        for(int i = 0; i < 3; i++)
            System.out.println(new Problem3().solution(commands[i], buttons[i], scores[i]));
    }

    private int n, answer;
    private boolean[] visit, check;
    private String[] buttons;
    private int[] scores;
    private String command;

    public int solution(String command, String[] buttons, int[] scores) {
        this.command = command;
        this.buttons = buttons;
        this.scores = scores;

        answer = command.length();
        check = new boolean[command.length()];
        n = buttons.length;
        visit = new boolean[n];

        permutation(0);

        return answer;
    }

    private void permutation(int total) {
        int score = total;
        for(boolean c : check) {
            if(!c)
                score++;
        }
        if(answer < score)
            answer = score;

        for(int i = 0; i < n; i++) {
            if(!visit[i] && isUsable(buttons[i])) {
                visit[i] = true;
                toggleButton(buttons[i]);
                permutation(total + scores[i]);
                visit[i] = false;
                toggleButton(buttons[i]);
            }
        }
    }

    private void toggleButton(String button) {
        int index = command.indexOf(button);
        for(int j = index; j < index + button.length(); j++) {
            check[j] = !check[j];
        }
    }

    private boolean isUsable(String button) {
        int index = command.indexOf(button);
        for(int j = index; j < index + button.length(); j++) {
            if(check[j])
                return false;
        }
        return true;
    }
}
