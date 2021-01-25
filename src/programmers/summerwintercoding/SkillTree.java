package programmers.summerwintercoding;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(new SkillTree().solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees) {
            boolean finish = true;
            int prev_index = Integer.MIN_VALUE;
            for(int i = 0; i < skill.length(); i++) {
                int index = skill_tree.indexOf(skill.charAt(i));
                if((index > prev_index && prev_index != -1) || index == -1)
                    prev_index = index;
                else {
                    finish = false;
                    break;
                }
            }
            if(finish)
                answer++;
        }
        return answer;
    }
}
