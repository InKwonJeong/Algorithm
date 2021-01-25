package programmers.summerwintercoding2;

import java.util.HashMap;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new SkillTree().solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        HashMap<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < skill.length(); i++)
            index.put(skill.charAt(i), i);

        for(String skill_tree : skill_trees) {
            boolean finish = true;
            HashMap<Character, Boolean> master = new HashMap<>();
            for(char c : skill.toCharArray())
                master.put(c, false);

            for(char c : skill_tree.toCharArray()) {
                if(master.get(c) != null) {
                    int i = index.get(c);
                    if(i == 0 || i != 0 && master.get(skill.charAt(i - 1))) {
                        master.put(c, true);
                    } else {
                        finish = false;
                        break;
                    }
                }
            }

            if(finish)
                answer++;
        }

        return answer;
    }
}
