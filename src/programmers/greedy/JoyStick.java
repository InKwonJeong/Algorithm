package programmers.greedy;

public class JoyStick {
    public static void main(String[] args) {
        String[] names = {"JAZ", "JEROEN", "JAN"};
        for(String name : names)
            System.out.println(new JoyStick().solution(name));
    }

    public int solution(String name) {
        int answer = 0;
        boolean[] finish = new boolean[name.length()];

        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A')
                finish[i] = true;
        }

        int index = 0;
        while (true) {
            int count = name.charAt(index) - 'A';
            if(count > 13)
                count = 26 - count;
            answer += count;
            finish[index] = true;

            int next = -1;
            for(int i = 1; i < name.length(); i++) {
                if(!finish[(index + i) % name.length()]) {
                    next = (index + i) % name.length();
                    answer += i;
                    break;
                } else if(!finish[(name.length() + index - i) % name.length()]) {
                    next = (name.length() + index - i) % name.length();
                    answer += i;
                    break;
                }
            }

            if(next == -1)
                break;

            index = next;
        }

        return answer;
    }
}
