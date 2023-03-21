package Level1;

import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
K 번째 수
 */
public class k_num {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                list.add(array[j - 1]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
            list.clear();
        }

        return answer;
    }
}
