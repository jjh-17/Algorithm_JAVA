package Level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993
public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String str = "";
            char[] skill_tree_arr = skill_tree.toCharArray();

            for (Character c : skill_tree_arr) {
                if (skill.indexOf(c) != -1)
                    str += c.toString();
            }

            if (skill.startsWith(str)) {
                answer += 1;
            }
        }

        return answer;
    }
}
